/**
 * Overridden/replacement for {@link ActionSupport}.
 */
public class MyActionSupport extends ActionSupport {

    public String text(String fieldName) {
        return "<!-- " + fieldName + " --> " + getText(fieldName);
    }
}