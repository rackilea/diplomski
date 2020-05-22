public static void addTestResults() throws ClientProtocolException, IOException {
     String pat = "abc@abc.com:xxxxxxxxxxxxxxxxxxxxxx";
     byte[] byteArray2 = Base64.encodeBase64(pat.getBytes());
     String encodedString2 = new String(byteArray2);
    String reqbody = "{\n" + 
            "        \"state\": \"Completed\",\n" + 
            "        \"testPoint\": {\n" + 
            "          \"id\": 40\n" + 
            "        },\n" + 
            "        \"outcome\": \"Passed\",\n" + 
            "        \"testCase\": {\n" + 
            "          \"id\": 7390\n" + 
            "        }\n" + 
            "      }";
     HttpClient httpClient = HttpClientBuilder.create().build();
     HttpPost postRequest = new HttpPost("https://xxx.visualstudio.com/DefaultCollection/XXX/_apis/test/runs/1000012/results?api-version=5.0-preview.5" );


     try {
         postRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
         patchRequest.setHeader(HttpHeaders.ACCEPT, "application/json");
         postRequest.setHeader("Authorization", "Basic "+encodedString2);
         postRequest.setEntity(new StringEntity(reqbody, ContentType.APPLICATION_JSON));

         HttpResponse response = httpClient.execute(postRequest);
         System.out.println("Out is"+EntityUtils.toString(response.getEntity()));

     }    catch (IOException e) {
         e.printStackTrace();
     }
}