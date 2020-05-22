import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateTests {

    @Mock
    private RestTemplate restTemplate;

    private String testUrl = "myurl";
    @InjectMocks
    private MyService serviceClass;

    @Test
    public void test1() {
        String expectedBody = "hey";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(expectedBody, HttpStatus.OK);
        when(restTemplate.exchange(eq(testUrl), eq(HttpMethod.POST), any(), eq(String.class)))
                .thenReturn(responseEntity);
        String s2 = serviceClass.serviceCall("s1");
        verify(restTemplate, times(1)).exchange(eq(testUrl), any(), any(), eq(String.class));
        assertEquals(s2, expectedBody);
    }
}