org.springframework.http.HttpHeaders headers = new 
org.springframework.http.HttpHeaders();
headers.set("Accept", "application/xml");
headers.set("username", "ABC");

String url = "http://<hostname>:7001/api?id=231";
ResponseEntity<ResponseObject> getEntity = 
this.restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<>( headers),ResponseObject.class);
return getEntity .getBody();