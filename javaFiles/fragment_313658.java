WebService webService = new WebService("http://192.168.1.2:8080/data/resources/converter.user/");

String response = webService.webGet("123333");

//Use this method to do a HttpGet/WebGet on the web service
public String webGet(String methodName) {
    String getUrl = webServiceUrl + methodName;

    httpGet = new HttpGet(getUrl);
    Log.e("WebGetURL: ",getUrl);

    try {
        response = httpClient.execute(httpGet);
    } catch (Exception e) {
        Log.e("Groshie:", e.getMessage());
    }

    // we assume that the response body contains the error message
    try {
        ret = EntityUtils.toString(response.getEntity());
    } catch (IOException e) {
        Log.e("Groshie:", e.getMessage());
    }

    return ret;
}