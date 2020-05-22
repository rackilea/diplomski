@Component
public class AppBCaller {

  @Autowired RestTemplate template;

  public String getInfo() {
    String plainCreds = "username:password";
    byte[] plainCredsBytes = plainCreds.getBytes();
    byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
    String base64Creds = new String(base64CredsBytes);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Authorization", "Basic " + base64Creds);

    HttpEntity<String> request = new HttpEntity<String>(headers);
    ResponseEntity<String> response = restTemplate.exchange("http://whereAppBis/v/getInfo", HttpMethod.GET, request, String.class);
    return response.getBody();
  }
}