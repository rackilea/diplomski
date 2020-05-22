@Component
@ConfigurationProperties("source")
@Validated
public class SourceProperties {

  @ValidJsonConstraint
  private String someJsonString;

  public String getSomeJsonString() {
    return someJsonString;
  }

  public void setSomeJsonString(String someJsonString) {
    this.someJsonString = someJsonString;
  }
}