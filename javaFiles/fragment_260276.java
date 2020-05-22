import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class AutowireTest {
  @Value("default")
  public String testField;

  @PostConstruct
  public void init() {
    if (testField == null)
      throw new RuntimeException("FAIL");
  }

  public void setTestField(String testField) {
    this.testField = testField;
  }
}