@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.PROPERTY,
    property = "type")
@JsonSubTypes(value = {
    @Type(value = GeoEntity.class, name = "geo"),
    @Type(value = FioEntity.class, name = "fio"),
    @Type(value = Number.class, name ="number")
})
public abstract class Entity {

  public void setType(String type) {
    this.type = type;
  }

  private String type;

  @Override
  public String toString(){
    return ToStringBuilder.reflectionToString(this);
  }

}