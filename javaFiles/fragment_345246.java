public class ErrorCodeMatcher extends BaseMatcher<CustomException> {
  private final String expectedCode;

  public ErrorCodeMatcher(String expectedCode) {
    this.expectedCode = expectedCode;
  }

  @Override
  public boolean matches(Object item) {
    CustomException e = (CustomException)item;
    return expectedCode.equals(e.getInformationCode());
  }
}