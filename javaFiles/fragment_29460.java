@Document
class MyEntity {

  @Field("foo")
  private String myField;

  public MyEntity(String myField) {
    this.myField = myField;
  }
}