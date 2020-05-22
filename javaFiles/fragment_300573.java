import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MyService {
    private String someurl = "myurl";
    private RestTemplate restTemplate = new RestTemplate();

    public String serviceCall(String s1) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("headers1", "headers1");

        HttpEntity<String> entity = new HttpEntity<String>(s1, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(someurl, HttpMethod.POST, entity, String.class);

        return responseEntity.getBody();
    }

}