public void sendMT() {
    RestTemplate restTemplate = new RestTemplate();
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    final String uri = "http://localhost:7000/sms/send";
    try {
        String json = ow.writeValueAsString(mt);
        RequestEntity<String> requestEntity = RequestEntity.post(new URL(uri).toURI()).contentType(MediaType.APPLICATION_JSON).body(json);
        ResponseEntity<String> output = restTemplate.exchange(requestEntity, String.class);
        System.out.println(output);
    } catch (Exception e) {
        e.printStackTrace();
    }
}