public class ProvidersRemoteFilter implements ProvidersFilter<Query> {

    private Query mQuery;

    @Override
    public void setQuery(@NonNull Query query) {
        mQuery = query;
    }

    @Override
    public Query apply() {
        return mQuery;
    }
}