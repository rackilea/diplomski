public static void main(String[] args) {
    String url = "xxxxx-yyyyy-r6nvlhpscgdwms5.ap-northeast-1.es.amazonaws.com/inventory/simple/123";

    RequestSpecification restAssuredRequest;
    restAssuredRequest = RestAssured.given();

    JSONObject restAssuredRequestParams = new JSONObject();
    restAssuredRequestParams.put("AccessToken", accessToken);
    restAssuredRequestParams.put("YourParam1", object1);
    restAssuredRequestParams.put("YourParam2", object2);

    /**
     * Add host without http or https protocol.
     * You can also add other parameters based on your amazon service requirement.
     */
    TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
    awsHeaders.put("host", "xxxxx-yyyyy-r6nvlhpscgdwms5.ap-northeast-1.es.amazonaws.com");

    AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder("exampleKey", "exampleSecret", "exampleSessionToken")
                                       .regionName("xx-yy-zzz")
                                       .serviceName("es") // es - elastic search. use your service name
                                       .httpMethodName("GET") //GET, PUT, POST, DELETE, etc...
                                       .canonicalURI("/inventory/simple/123") //end point
                                       .queryParametes(null) //query parameters if any
                                       .awsHeaders(awsHeaders) //aws header parameters
                                       .payload(restAssuredRequestParams) // payload if any
                                       .debug() // turn on the debug mode
                                       .build();

    /* Get header calculated for request */
    Map<String, String> header = aWSV4Auth.getHeaders();
    for (Map.Entry<String, String> entrySet : header.entrySet()) {
        String key = entrySet.getKey();
        String value = entrySet.getValue();
        restAssuredRequest.header(key, value);

        /* Attach header in your request */
        /* Simple get request */
        //HttpGet httpGet = new HttpGet(url);
        //httpGet.addHeader(key, value);
    }
    restAssuredRequest.body(restAssuredRequestParams);
    Response restAssuredResponse = restAssuredRequest.post(endpoint path);
    System.out.println(restAssuredResponse.asString());
    System.out.println(restAssuredResponse.getStatusCode());
}