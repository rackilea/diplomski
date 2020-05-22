private static int processPostRequest(URL url, byte[] data, String contentType, String keyStore, String keyStorePassword) throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException, IOException, ProtocolException {
    SSLSocketFactory sslFactory = getSSLSocketFactory(keyStore, keyStorePassword);
    HttpsURLConnection con = null;
    con = (HttpsURLConnection) url.openConnection();
    con.setSSLSocketFactory(sslFactory);
    con.setDoOutput(true);
    con.setRequestMethod("POST");
    con.addRequestProperty("x-ms-version", "2013-08-01");
    con.setRequestProperty("Content-Length", String.valueOf(data.length));
    con.setRequestProperty("Content-Type", contentType);

    DataOutputStream  requestStream = new DataOutputStream (con.getOutputStream());
    requestStream.write(data);
    requestStream.flush();
    requestStream.close();
    int responseCode = con.getResponseCode();
    InputStream errorStream = con.getErrorStream();
    if (errorStream != null) {
        String detailedErrorMessage = getStringFromInputStream(errorStream);
        System.out.println(detailedErrorMessage);
    }
    return responseCode;
}