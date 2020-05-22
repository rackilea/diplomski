org.apache.http.HttpResponse response = Request.Get(url)
    .connectTimeout(CONNECTION_TIMEOUT_MILLIS)
    .socketTimeout(SOCKET_TIMEOUT_MILLIS)
    .execute()
    .returnResponse();

int status = response.getStatusLine().getStatusCode();
byte[] serializedObject = EntityUtils.toByteArray(response.getEntity());