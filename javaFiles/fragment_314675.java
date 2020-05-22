// Model.java
@DynamoDBTable(tableName = "...")
public class Model {
  private String id;
  private List<MyObject> objects;

  public Model(String id, List<MyObject> objects) {
    this.id = id;
    this.objects = objects;
  }

  @DynamoDBHashKey(attributeName = "id")
  public String getId() { return this.id; }
  public void setId(String id) { this.id = id; }

  @DynamoDBTypeConverted(converter = MyObjectConverter.class)
  public List<MyObject> getObjects() { return this.objects; }
  public void setObjects(List<MyObject> objects) { this.objects = objects; }
}