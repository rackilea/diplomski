public class SearchContextElementLocatorFactory
        implements ElementLocatorFactory {

    private final SearchContext context;

    public SearchContextElementLocatorFactory(SearchContext context) {
        this.context = context;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new DefaultElementLocator(context, field);
    }
}