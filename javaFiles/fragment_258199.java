@JsonDeserialize(using = MyPojoDeserializer.class)
public class MyPojo {
  protected String id;
  protected String content;
  protected String title;
  protected List<Property> property;

  // Getters/Setters

}