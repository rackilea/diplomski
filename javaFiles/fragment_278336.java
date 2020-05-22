public class ParentNameConverter extends AbstractConverter {

    /**
     * Converts a value from the subject to the type or format used
     * by this converter.
     *
     * @param subjectValue  the subject's value
     * @return the converted value in the type or format used by this converter
     */
    public Object convertFromSubject(Object subjectValue) { ... }


    /**
     * Sets a new value on the subject, after converting to appropriate type 
     * or format
     *
     * @param newValue the ui component's value
     */
    public void setValue(Object newValue) { ... }
}