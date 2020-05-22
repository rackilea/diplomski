public class StateConstraintValidator implements ConstraintValidator<String, String> {

    private static final Set<String> CODE_MAP = new HashSet<>(){
      {add("AR");}
      {add("AK");} //add more codes ...
    };

    @Override
    public void initialize(String state) { }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext cxt) {
        if(value == null) {
            return false;
        }
        return CODE_MAP.contains(value);
    }
}