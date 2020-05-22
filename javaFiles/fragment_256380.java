@Provider
public class GensonProvider implements ContextResolver<Genson> {

    private final Genson genson = new GensonBuilder()
            .useDateAsTimestamp(false)
            .useDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
            .create();

    @Override
    public Genson getContext(Class<?> type) {
        return genson;
    }
}