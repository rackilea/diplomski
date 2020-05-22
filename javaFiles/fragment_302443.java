/**
 * 
 */
package test;

/**
 * @author The Elite Gentleman
 *
 */
public enum Strings {
    STRING_ONE("ONE"),
    STRING_TWO("TWO")
    ;

    private final String text;

    /**
     * @param text
     */
    Strings(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}