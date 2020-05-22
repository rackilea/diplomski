final String url = "http://qrpromenad.azurewebsites.net/api/question?id=1&imei=35404304";

DefaultHttpClient httpClient = new DefaultHttpClient();
HttpGet get = new HttpGet(url);

HttpResponse httpResponse = httpClient.execute(get);

String responseData = null;
final int status = httpResponse.getStatusLine().getStatusCode();
if (status == HttpStatus.SC_OK) {
    responseData = EntityUtils.toString(httpResponse.getEntity());
} else {
    System.err.println("HTTP request failed with status " + status);
}

System.out.println(responseData);