public class LongLengthFieldValidator extends FieldValidatorSupport {

  private boolean doTrim = true;
  private int maxLength = -1;
  private int minLength = -1;


  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }

  public int getMaxLength() {
    return maxLength;
  }

  public void setMinLength(int minLength) {
    this.minLength = minLength;
  }

  public int getMinLength() {
    return minLength;
  }

  public void setTrim(boolean trim) {
    doTrim = trim;
  }

  public boolean getTrim() {
    return doTrim;
  }

  public void validate(Object object) throws ValidationException {
    String fieldName = getFieldName();
    String val = getFieldValue(fieldName, object).toString();

    if (val == null || val.length() <= 0) {
      // use a required validator for these
      return;
    }
    if (doTrim) {
      val = val.trim();
      if (val.length() <= 0) {
        // use a required validator
        return;
      }
    }

    if ((minLength > -1) && (val.length() < minLength)) {
      addFieldError(fieldName, object);
    } else if ((maxLength > -1) && (val.length() > maxLength)) {
      addFieldError(fieldName, object);
    }
  }
}