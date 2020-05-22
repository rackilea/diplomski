@Autowired restTemplate

String url = "http://localhost:8080/ItemServices/items/validate/{itemId}";
try {
    ResponseEntity<Object> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class, uriParms);
    int restCallStateCode = responseEntity.getStatusCodeValue();
} catch (ResponseEntityErrorException re) {
    ResponseEntity<ErrorResponse> errorResponse = re.getErrorResponse();
}