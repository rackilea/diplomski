RestTemplate template = new RestTemplate();
MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
headers.add("Accept", "application/json"); //put content-type you expect in response
String requestData = "sessionKey=eec8ff46-aaf9-485f-a7b5-452c1d7197d0&path=/contenthubfeedtest&recursive=true";
String url = "http://myadresse:8080/cmsadapter/contenthubfeed";
HttpEntity request = new HttpEntity(requestData, headers);
ResponseEntity<String> responseData = template.postForEntity(url,
                request, String.class);
System.out.println(responseData.getBody()); //response body
System.out.println(responseData.getStatusCode()); //response code
System.out.println(responseData.getHeaders()); //response headers