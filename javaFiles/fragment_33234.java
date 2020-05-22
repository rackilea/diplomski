@Test
public void testEncryptWithKey2() throws InterruptedException, ExecutionException, JSONException, URISyntaxException, ClientProtocolException, IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException
{
    AuthenticationContext ctx = new AuthenticationContext(AAD_TENANT_ENDPOINT, true, Executors.newFixedThreadPool(1));
    Future<AuthenticationResult> resp = ctx.acquireToken("https://vault.azure.net", new ClientCredential(AAD_CLIENT_ID, AAD_CLIENT_SECRET), null);
    AuthenticationResult res = resp.get();
    String auth_token = res.getAccessToken();


    String plainText = "This is another test";
    String plainTextB64Encoded = Base64.encodeBase64URLSafeString(plainText.getBytes("UTF-8"));
    JSONObject req = new JSONObject();
    req.put("alg", KEY_ENCRYPT_ALG);
    req.put("value", plainTextB64Encoded);
    byte[] payload = req.toString().getBytes("UTF-8");

    ByteArrayInputStream message = new ByteArrayInputStream(req.toString().getBytes("UTF-8"));      
    InputStreamEntity reqEntity = new InputStreamEntity(message, payload.length, JsonContentType);
    reqEntity.setChunked(false);

    URIBuilder ub = new URIBuilder(
            "https://aexpress-dev1-key-vault.vault.azure.net/keys/"+KEY_NAME+"/encrypt?api-version="+API_VERSION);
    URI uri = ub.build();
    HttpUriRequest request = RequestBuilder.post().setUri(uri)
            .setHeader(HttpHeaders.AUTHORIZATION, "Bearer "+auth_token)
            .setEntity(reqEntity).build();
    HttpClient client = HttpClientBuilder.create().build();
    HttpResponse response = client.execute(request);
    int status = response.getStatusLine().getStatusCode();
    HttpEntity entity = response.getEntity();
    String body = null;
    if(entity==null) {
        System.err.println("No body");
        throw new ClientProtocolException("Request failed: Response has no body status: "+status);
    }
    else {
        body = EntityUtils.toString(entity);
        if(status < 200 || status > 299)
        {
            System.out.println("Got error reply: " +body);
            throw new ClientProtocolException("Request failed: "+body+" status: "+status);
        }
    }
    JSONObject reply = new JSONObject(body);
    String encryptedText = reply.getString("value");
    entity.getContent().close();

    req = new JSONObject();
    req.put("alg", KEY_ENCRYPT_ALG);
    req.put("value", encryptedText);
    payload = req.toString().getBytes("UTF-8");

    message = new ByteArrayInputStream(payload);

    reqEntity = new InputStreamEntity(message, payload.length, JsonContentType);
    reqEntity.setChunked(false);

    ub = new URIBuilder(
            "https://aexpress-dev1-key-vault.vault.azure.net/keys/"+KEY_NAME+"/decrypt?api-version="+API_VERSION);
    uri = ub.build();
    request = RequestBuilder.post().setUri(uri)
            .setHeader(HttpHeaders.AUTHORIZATION, "Bearer "+auth_token)
            .setHeader("client-request-id", UUID.randomUUID().toString())
            .setEntity(reqEntity).build();
    response = client.execute(request);
    status = response.getStatusLine().getStatusCode();
    entity = response.getEntity();
    body = null;
    if(entity==null) {
        System.err.println("No body");
        throw new ClientProtocolException("Request failed: Response has no body status: "+status);
    }
    else {
        body = EntityUtils.toString(entity);
        if(status < 200 || status > 299)
        {
            System.out.println("Got error reply: " +body);
            throw new ClientProtocolException("Request failed: "+body+" status: "+status);
        }
    }
    reply = new JSONObject(body);
    String base64encodedDecryptedText = reply.getString("value");
    String decryptedText = new String(Base64.decodeBase64(base64encodedDecryptedText), "UTF-8");
    System.out.println(decryptedText.toString());
    Assert.assertTrue("Text did not decrypt to the same value", plainText.equals(decryptedText));
}