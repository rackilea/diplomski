public class CustomObjectMapper extends ObjectMapper {

  // here's the method you need
  @Override
  public <T> T readValue(String src, Class<T> type)
      throws IOException, JsonParseException, JsonMappingException {

    JsonNode root = this.readTree(src);
    try {
      return readNestedValue(root, type);
    } catch (InstantiationException | IllegalAccessException | IOException
        | IllegalArgumentException | InvocationTargetException e) {
      return super.readValue(src, type);
    }

  }

  // if you're using Spring, I suggest you implement this method as well
  // since Spring's MappingJacksonHttpMessageConverter class will call 
  // this method.
  @Override
  public <T> T readValue(InputStream src, JavaType type)
      throws IOException, JsonParseException, JsonMappingException {

    JsonNode root = this.readTree(src);
    try {
      return readNestedValue(root, (Class<T>) type.getRawClass());
    } catch (InstantiationException | IllegalAccessException | IOException
        | IllegalArgumentException | InvocationTargetException e) {
      return super.readValue(src, type);
    }

  }

  // we need this to recursively scan the tree node
  protected <T> T readNestedValue(JsonNode root, Class<T> type)
      throws InstantiationException, IllegalAccessException, IOException,
        IllegalArgumentException, InvocationTargetException {

    // initialize the object use ObjectMapper's readValue
    T obj = super.readValue(root, type);
    Iterator it = root.getFieldNames();
    while (it.hasNext()) {
      String name = (String) it.next();
      String camelCaseName = name.substring(0, 1).toUpperCase() + name.substring(1);
      JsonNode node = root.get(name);

      Field f;
      try {
        f = type.getDeclaredField(name);
      } catch (NoSuchFieldException e) {
        f = findFieldInSuperClass(name, type.getSuperclass());
      }
      // if no field found then ignore
      if (f == null) continue; 

      Method getter, setter;
      try {
        getter = type.getMethod("get" + camelCaseName);
      } catch (NoSuchMethodException e) {
        getter = findGetterInSuperClass("get" + camelCaseName, type.getSuperclass());
      }
      // if no getter found or it has been assigned then ignore
      if (getter == null || getter.invoke(obj) != null) continue;

      try {
        setter = type.getMethod("set" + camelCaseName);
      } catch (NoSuchMethodException ex) {
        setter = findSetterInSuperClass("set" + camelCaseName, type.getSuperclass(), f.getType());
      }
      // if no setter found then ignore
      if (setter == null) continue;

      setter.invoke(obj, readNestedValue(node, f.getType()));
    }

    return obj;
  }

  // we need this to search for field in super class
  // since type.getDeclaredField() will only return fields that in the class
  // but not super class
  protected Field findFieldInSuperClass(String name, Class sClass) {
    if (sClass == null) return null;
    try {
      Field f = sClass.getDeclaredField(name);
      return f;
    } catch (NoSuchFieldException e) {
      return findFieldInSuperClass(name, sClass.getSuperclass());
    }
  }

  protected Method findGetterInSuperClass(String name, Class sClass) {
    if (sClass == null) return null;
    try {
      Method m = sClass.getMethod(name);
      return m;
    } catch (NoSuchMethodException e) {
      return findGetterInSuperClass(name, sClass.getSuperclass());
    }
  }

  protected Method findSetterInSuperClass(String name, Class sClass, Class type) {
    if (sClass == null) return null;
    try {
      Method m = sClass.getMethod(name, type);
      return m;
    } catch (NoSuchMethodException e) {
      return findSetterInSuperClass(name, sClass.getSuperclass(), type);
    }
  }
}