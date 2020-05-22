public abstract class AbstractHTTPFactory {
    public final ArrayList<? extends LGCookObject> make()
            throws HTTPFactoryException {
        String response = sr.getData(getURL());
        ...
    }

    protected abstract String getURL();
}

public class RecipesHTTPFactory extends AbstractHTTPFactory {
    protected String getURL() {
        return "VALUE";
    }
}