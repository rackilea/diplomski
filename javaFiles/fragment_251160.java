long startTime = System.currentTimeMillis();

HttpResponse response = httpClient.execute(httpPost);

long elapsedTime = System.currentTimeMillis() - startTime;

Log.d("j", "Total elapsed http request/response time in milliseconds" + elapsedTime);
System.out.println("Total elapsed http request/response time in milliseconds: " + elapsedTime);
if (response.getStatusLine().getStatusCode() == 200) {
    return EntityUtils.toString(response.getEntity());
}