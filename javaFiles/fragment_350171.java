public static void putContainer() throws Exception {
    // Account info
    String accountName = "accountName";
    String accountKey = "accountKey";

    // Request Uri and Method
    String containerName = "containerName";
    String requestUri = "https://"+accountName+".blob.core.windows.net/"+containerName+"?restype=container&timeout=60";
    HttpURLConnection connection = (HttpURLConnection) (new URL(requestUri)).openConnection();
    connection.setRequestMethod("PUT");

    // Request Headers
    // 1. x-ms-version, recommend to use the latest version if possible
    String serviceVersion = "2018-03-28";
    // 2. x-ms-date
    SimpleDateFormat fmt = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
    fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
    String date = fmt.format(Calendar.getInstance().getTime()) + " GMT";
    // 3. Authorization
    String authKeyFormat = "SharedKey";
    String caHeader = "x-ms-date:"+date+"\nx-ms-version:"+serviceVersion+"\n";
    String caResource = "/"+accountName+"/"+containerName+"\nrestype:container\ntimeout:60";
    String signStr = "PUT\n\n\n\n\n\n\n\n\n\n\n\n"+caHeader+caResource;
    String authorization = getAuthorization(accountName, authKeyFormat, signStr, accountKey);

    // Send request
    connection.setRequestProperty("x-ms-version", serviceVersion);
    connection.setRequestProperty("x-ms-date",date);
    connection.setRequestProperty("Authorization", authorization);
    // Send 0 byte, code sets Content-Length:0 automatically
    connection.setDoOutput(true);
    connection.setFixedLengthStreamingMode(0);

    System.out.println("Response message : " + connection.getResponseMessage());
    System.out.println("Response code : " + connection.getResponseCode());
}

private static String getAuthorization(String accountName, String authKeyFormat, String signStr, String accountKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

    SecretKeySpec secretKey = new SecretKeySpec(Base64.getDecoder().decode(accountKey), "HmacSHA256");
    Mac sha256HMAC = Mac.getInstance("HmacSHA256");
    sha256HMAC.init(secretKey);
    String signature = Base64.getEncoder().encodeToString(sha256HMAC.doFinal(signStr.getBytes("UTF-8")));

    return authKeyFormat+" "+accountName+":"+signature;
}