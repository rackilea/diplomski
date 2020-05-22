import static org.mockito.ArgumentMatchers.any;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Test
    public void test() {

        RestTemplate api = Mockito.mock(RestTemplate.class);
        ResponseEntity<?> response1 = Mockito.mock(ResponseEntity.class);
        ResponseEntity<?> response2 = Mockito.mock(ResponseEntity.class);

        Mockito.when(api.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(response1);
        Mockito.when(api.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(ParameterizedTypeReference.class))).thenReturn(response2);

        ParameterizedTypeReference mock = Mockito.mock(ParameterizedTypeReference.class);

        Assert.assertEquals(response1, api.exchange("", HttpMethod.GET, new HttpEntity(""), String.class));
        Assert.assertEquals(response2, api.exchange("", HttpMethod.GET, new HttpEntity(""), mock));
    }
}