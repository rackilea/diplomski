@GetMapping(path = "/testingAsync")
public ListenableFuture<ResponseEntity<User>> value() throws ExecutionException, InterruptedException, TimeoutException {
    AsyncRestTemplate restTemplate = new AsyncRestTemplate();
    String baseUrl = "https://api.github.com/users/XXX";
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    String value = "";

    HttpEntity entity = new HttpEntity("parameters", requestHeaders);
    return restTemplate.getForEntity(baseUrl, User.class);
}