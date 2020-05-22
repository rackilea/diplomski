// Should be thread safe
public class HttpClientFactory {

            private static DefaultHttpClient client;

            public synchronized static DefaultHttpClient getThreadSafeClient() {
                    if (client != null)
                            return client;
                    client = new DefaultHttpClient();
                    ClientConnectionManager mgr = client.getConnectionManager();
                    HttpParams params = client.getParams();
                    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params,
                                    mgr.getSchemeRegistry()), params);
                return client;

            }
    }