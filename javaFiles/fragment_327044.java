import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DemoApplicationTests {
    @Mock
    private RestTemplate restTemplate;
    @Test
    public void testy() {
        Mockito.when(restTemplate.getForObject(Mockito.anyString(), Mockito.any(), (Object) Mockito.any())).thenReturn("this works");
        Assert.assertEquals("this works", restTemplate.getForObject("hi", String.class, 42, 45));
    }

}