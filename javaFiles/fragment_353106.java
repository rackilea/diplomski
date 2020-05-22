public final class SomeThing{

  private String val;

  @JsonCreator
  public static SomeThing create(final String value) {
    SomeThing result = new SomeThing();
    result.setValue(value);
    return result;
  }

  public void setValue(String value) {
    this.val = value;
  }
}