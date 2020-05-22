public class CancellableSimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

    private List<Object> cancellableResources;

    public CancellableSimpleClientHttpRequestFactory() {
    }

    public CancellableSimpleClientHttpRequestFactory(List<Object> cancellableResources) {
        this.cancellableResources = cancellableResources;
    }

    protected HttpURLConnection openConnection(URL url, Proxy proxy) throws IOException {
        HttpURLConnection connection = super.openConnection(url, proxy);
        if (cancellableResources != null) {
            cancellableResources.add(connection);
        }
        return connection;
    }
}