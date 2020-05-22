//  class
    public class Client {

        /*** restTemplate unique instance for every unique HTTP server. ***/
        @Autowired
        RestTemplate restTemplate;

        public ResponseEntity<String> sendUser() {

        String url = "http://localhost:8080/user/add";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        User test = new User();
        test.setName("test");
        test.setEmail("a@hotmail.com");
        test.setScore(205);

        HttpEntity<User> request = new HttpEntity<>(test);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        if(response.getStatusCode() == HttpStatus.OK){
            System.out.println("user response: OK");
        }
        return response;
      }
  }