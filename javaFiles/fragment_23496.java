// Do once
HttpClient client = HttpClients.createDefault();
HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(factory));

// Do anytime
byte[] plainCredsBytes = "uname:password".getBytes();
byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
String base64Creds = new String(base64CredsBytes);

HttpHeaders headers = new HttpHeaders();
headers.add("Authorization", "Basic " + base64Creds);

ResponseEntity<String> response = restTemplate.postForEntity(
        "https://qualysapi.qg2.apps.qualys.eu/qps/rest/3.0/search/was/wasscan/",
        new HttpEntity(headers), String.class);

if (response.getStatusCode() == HttpStatus.OK) {
    Files.writeString(Paths.get("was_finding.txt"), response.getBody());
} else {
    // Handle status code, etc.
}