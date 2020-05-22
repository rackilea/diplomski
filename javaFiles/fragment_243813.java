package myvalidators;

import javax.validation.*;

public class AllUpperCaseValidator 
        extends play.data.validation.Constraints.Validator<Object> 
        implements ConstraintValidator<AllUpperCase, Object> {

    /* Default error message */
    final static public String message = "error.alluppercase";

    /**
     * Validator init
     * Can be used to initialize the validation based on parameters
     * passed to the annotation.
     */
    public void initialize(AllUpperCase constraintAnnotation) {}

    /**
     * The validation itself
     */
    public boolean isValid(Object object) {
        if(object == null)
            return false;

        if(!(object instanceof String))
            return false;

        String s = object.toString();  
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c) && Character.isLowerCase(c))
                return false;
        }

        return true;
    }

    /**
     * Constructs a validator instance.
     */
    public static play.data.validation.Constraints.Validator<Object> alluppercase() {
        return new AllUpperCaseValidator();
    }
}