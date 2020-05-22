Message msg = new Message();
msg.setMessage("I am very frustrated.");
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
List<Charset> acceptCharset = Collections.singletonList(StandardCharsets.UTF_8);
headers.setAcceptCharset(acceptCharset);
log.info(headers.toString());

HttpEntity<Message> entity = new HttpEntity<>(msg, headers);
ResponseEntity<String> res = restTemplate.exchange("http://httpbin.org/post", HttpMethod.POST, entity, String.class);
String httpbin = res.getBody();

log.info("httpbin result: " + httpbin);