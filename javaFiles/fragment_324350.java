public static String getToken() throws Exception {
    String TENANT_ID = "your tenant id or name, e4c9*-*-*-*-*57fb";
    String AUTHORITY = "https://login.microsoftonline.com/" + TENANT_ID;
    String CLIENT_ID = "your application id, dc17*-*-*-*a5e7";
    String CLIENT_SECRET = "the secret, /pG*32";
    String RESOURCE = "https://storage.azure.com/";
    String ACCESS_TOKEN = null;
    ExecutorService service = Executors.newFixedThreadPool(1);
    AuthenticationContext context = null;
    try {
        context = new AuthenticationContext(AUTHORITY, false, service);
        ClientCredential credential = new ClientCredential(CLIENT_ID, CLIENT_SECRET);
        Future<AuthenticationResult> future = context.acquireToken(RESOURCE, credential, null);
        ACCESS_TOKEN = future.get().getAccessToken();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } finally {
        service.shutdown();
    }
    return ACCESS_TOKEN;
}