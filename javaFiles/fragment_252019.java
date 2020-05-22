HttpContext context = null;
if(feedSpec.isAuthenticated()) {
    context = new BasicHttpContext();
    CredentialsProvider credsProvider = new BasicCredentialsProvider();
    credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(feedSpec.getHttpUsername(), feedSpec.getHttpPassword(), "", ""));
    context.setAttribute(ClientContext.CREDS_PROVIDER, credsProvider);
}
HttpGet httpGet = new HttpGet(feedSpec.getUri());
HttpResponse httpResponse = httpClient.execute(httpGet, context);