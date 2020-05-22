public static class NaiveObjectMapper {
  private Map<String, Object> fieldsAndMethods;
  private NaiveJsonParser parser;

  public <T> T readValue(String content, Class<T> valueType) {
    parser = new NaiveJsonParser(content);

    try {
      // aggregate all value type fields and methods inside a map
     fieldsAndMethods = new HashMap<>();
      for (Field field : valueType.getDeclaredFields()) {
        fieldsAndMethods.put(field.getName(), field);
      }
      for (Method method : valueType.getMethods()) {
        fieldsAndMethods.put(method.getName(), method);
      }

      // create an instance of value type by calling its default constructor
      Constructor<T> constructor = valueType.getConstructor();
     Object bean = constructor.newInstance(new Object[0]);

      // loop through all json nodes
      String propName;
      while ((propName = parser.nextFieldName()) != null) {
        // find the corresponding field
        Field prop = (Field) fieldsAndMethods.get(propName);
        // get and set field value
        deserializeAndSet(prop, bean);
      }
      return (T) bean;
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
     e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }

    return null;
  }

  private void deserializeAndSet(Field prop, Object bean) {
    Class<?> propType = prop.getType();
    Method setter = (Method) fieldsAndMethods.get(getFieldSetterName(prop));
    try {
      if (propType.isPrimitive()) {
        if (propType.getName().equals("int")) {
          setter.invoke(bean, parser.getIntValue());
        }
      } else if (propType == String.class) {
        setter.invoke(bean, parser.getTextValue());
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  private String getFieldSetterName(Field prop) {
    String propName = prop.getName();
    return "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
  }
}

class NaiveJsonParser {
  String[] nodes;
  int currentNodeIdx = -1;
  String currentProperty;
  String currentValueStr;

  public NaiveJsonParser(String content) {
    // split the content into 'property:value' nodes
    nodes = content.replaceAll("[{}]", "").split(",");
 }

  public String nextFieldName() {
    if ((++currentNodeIdx) >= nodes.length) {
      return null;
    }
    String[] propertyAndValue = nodes[currentNodeIdx].split(":");
    currentProperty = propertyAndValue[0].replace("\"", "").trim();
    currentValueStr = propertyAndValue[1].replace("\"", "").trim();
    return currentProperty;
  }

  public String getTextValue() {
    return String.valueOf(currentValueStr);
  }

  public int getIntValue() {
    return Integer.valueOf(currentValueStr).intValue();
  }
}

public static class User {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "id = " + id + ", name = \"" + name + "\"";
  }
}