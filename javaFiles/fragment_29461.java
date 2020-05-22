@Document
class MyEntity {

  @Field("foo")
  private String myField;

  public MyEntity(@Value("#root.foo") String somethingDifferent) {
    this.myField = somethingDifferent;
  }
}