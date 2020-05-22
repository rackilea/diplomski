public class RegexValidator implements Validator, StateHolder {
  private boolean isTransient;
  private String regex;

  public String getRegex() { return regex; }
  public void setRegex(String regex) { this.regex = regex; }

  public void validate(FacesContext context, UIComponent component, Object value)
      throws ValidatorException {
    //TODO: throw ValidatorException if not valid
  }

  //TODO: implement remaining StateHolder methods...
}