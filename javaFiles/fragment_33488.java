public class Service{

    RestTemplate restTemplate = new RestTemplate();

    public boolean isEnabled(String xxx) {
        ResponseEntity<String> response = restTemplate.getForEntity("someurl",String.class);
        if(...)return true;
        return false;
    }
}