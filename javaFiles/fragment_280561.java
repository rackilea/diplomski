RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> s = restTemplate.exchange("http://localhost:8080/demo.rest.springsecurity.oauth2.0.authentication/oauth/token?username=user1&password=user1&client_id=client1&client_secret=client1&grant_type=password&scope=read", HttpMethod.POST, entity, String.class);
        System.out.println(s.getBody().toString());