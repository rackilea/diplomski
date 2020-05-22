public class LengthValidator extends ValidatedConversion {

    private int min;
    private int max;

    public LengthValidator(String... args) {
        super(false, false); //not null / not blank
        this.min = Integer.parseInt(args[0]);
        this.max = Integer.parseInt(args[1]);
    }

    @Override
    protected void validate(Object value) {
        super.validate(value); //let super check for null and whatever you need.
        String string = value.toString();
        if(string.length() < min || string.length() > max){
            throw new com.univocity.parsers.common.DataValidationException("Value can't have length " + string.length());
        }
    }
}