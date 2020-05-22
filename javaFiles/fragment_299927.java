@Component
@ConfigurationProperties("source")
public class SourceProperties {

  private final JsonValidator jsonValidator;

  private String someJsonString;

  public SourceProperties(JsonValidator jsonValidator) {
    this.jsonValidator = jsonValidator;
  }

  public String getSomeJsonString() {
    return someJsonString;
  }

  public void setSomeJsonString(String someJsonString) {
    if (!jsonValidator.isValid(someJsonString)) {
      throw new IllegalArgumentException(someJsonString + " is not a valid JSON");
    }
    this.someJsonString = someJsonString;
  }
}