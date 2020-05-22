public class Attributes extends AbstractMap<String, String> {
    private final LinkedHashMap<String, String> delegate;

    public Attributes() {
        this(Collections.emptyMap());
    }

    public Attributes(Map<? extends String, ? extends String> map) {
        this.delegate = new LinkedHashMap<>(map);
    }

    // Override the methods you need to, and that are required by AbstractMap.
    // Details of methods to override in AbstractMap are given in Javadoc.
}