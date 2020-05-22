public class SkillsSet<T extends SkillType> { 
    private Map<T,Integer> skills = new HashMap<>();

    // These don't have to be class members, they could be passed
    // around as parameters
    private T[] enumConstants;   // needed only for getEnumValue
    private Class<T> enumClass;  // needed only for getEnumValueAlternate

    public SkillsSet(String[] skills, Class<T> enumClass) {
        // Though all implementers of SkillType are currently enums, it is safer
        // to do some type checking before we do any reflection things
        enumConstants = enumClass.getEnumConstants();
        if (enumConstants == null)
            throw new IllegalArgumentException("enumClass is not an enum");

        for (String string : skills) {
            T t = getEnumValue(string)
            if (t == null) {
                // or use continue if you dont want to throw an exception
                throw new IllegalArgumentException();
            }
            this.skills.put(t, t.getPenalty());
        }
    }

    // These don't even need to be methods, but I separated them for clarity.
    // SuppressWarnings annotation is used since we checked types in the constructor
    @SuppressWarnings( "unchecked" )
    public T getEnumValue( String string ) {
        try {
            return (T) enumConstants[0].fromValue(string);
        }

        // If valueOf does not find a match, it throws IllegalArgumentExecption
        catch ( IllegalArgumentException e ) {
            return null;
        }
    }

    // An alternate version  of getEnumValue that does not require the 'fromValue'
    // method on the SkillType interface.
    @SuppressWarnings( "unchecked" )
    public T getEnumValueAlternate( String string ) {
        try {
            return (T) enumClass.getMethod("valueOf", String.class).invoke(null, string)
        }

        // Any reflection exceptions are treated as 'not found' on valueOf
        catch (Exception e) {
            return null; 
        }
    }


    ...
}