final String uri = "http://localhost:8080/";

    Message message = new Message(1, "Adam",true);

    RestTemplate restTemplate = new RestTemplate();
    Message result = restTemplate.postForObject( uri, message, Message.class);