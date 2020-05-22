public abstract class AbstractHTTPFactory {
    private final String url;

    public final ArrayList<? extends LGCookObject> make()
            throws HTTPFactoryException {
        String response = sr.getData(url);
        ...
    }

    protected AbstractHTTPFactory(String url) {
        this.url = url;
    }
}

public class RecipesHTTPFactory extends AbstractHTTPFactory {
    public RecipesHTTPFactory() {
        super("VALUE");
    }
}