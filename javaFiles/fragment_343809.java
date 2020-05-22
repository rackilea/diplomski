@ScriptAssert(lang = "javascript", script = "_this.minimumAge < _this.maximumAge")
public class MyBean {

  @Min(1)
  private int minimumAge;

  @Max(99)
  private int maximumAge;

}