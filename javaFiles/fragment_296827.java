try {
PersonResponse response = restTemplate.postForObject(url, request, PersonResponse.class);
} catch (HttpStatusCodeException se) {
  log.debug(se.getResponseBodyAsString()); 
  // I was able to see the error information stored in PersonResponse in the log
// Here you have to implement to map the error with PersonResponse 
 ResponseStatus  errorStatus = new ResponseStatus();
 errorStatus.setErrorCode(HTTP500);
 errorStatus.setErrorMessage(YOURMESSAGEFROMERROR);
 PersonResponse  responseObject = new PersonResponse();
 responseObject.setResponseStatus(errorStatus);
 return new ResponseEntity<PersonResponse>(responseObject,HTTPStatus.200Or500); // you can design as you need 200 or 500
 } catch (HttpClientErrorException ex){
   //same way for HTTP 4xx 
}