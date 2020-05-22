// outputs:
// [Container: obj=[ChildContainer: children=[[Child: id=1], [Child: id=2]]]]
// [Container: obj=[ChildContainer: children=[[Child: id=1]]]]

public class Foo
{
  static String json1 = "{\"obj\":{\"children\":[{\"id\":\"1\"},{\"id\":\"2\"}]}}";
  static String json2 = "{\"obj\":{\"children\":{\"id\":\"1\"}}}";

  public static void main(String[] args)
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
    gsonBuilder.registerTypeAdapter(Child[].class, new ChildrenDeserializer());
    Gson gson = gsonBuilder.create();
    Container container1 = gson.fromJson(json1, Container.class);
    System.out.println(container1);

    Container container2 = gson.fromJson(json2, Container.class);
    System.out.println(container2);
  }
}

class Container
{
  ChildContainer obj;

  @Override
  public String toString()
  {
    return String.format("[Container: obj=%1$s]", obj);
  }
}

class ChildContainer
{
  Child[] children;

  @Override
  public String toString()
  {
    return String.format("[ChildContainer: children=%1$s]", Arrays.toString(children));
  }
}

class Child
{
  String id;

  @Override
  public String toString()
  {
    return String.format("[Child: id=%1$s]", id);
  }
}

class ChildrenDeserializer implements JsonDeserializer<Child[]>
{
  @Override
  public Child[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException
  {
    if (json instanceof JsonArray)
    {
      return new Gson().fromJson(json, Child[].class);
    }
    Child child = context.deserialize(json, Child.class);
    return new Child[] { child };
  }
}