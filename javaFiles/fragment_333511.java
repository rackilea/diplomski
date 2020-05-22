public class IsUserName implements IParameterValidator {
  public void validate(String name, String value)
    throws ParameterException {
      if (value.startsWith("--")) {
        throw new ParameterException("probably missing user name"); 
      }
  }
}

@Parameter(names = "--user", validateWith = IsUserName.class)
private String user;