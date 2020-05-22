import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class MyServiceTest {

    @InjectMocks
    private MyService myService;

    @Mock
    private Utility utility;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowResult() throws Exception {
        when(utility.getName()).thenReturn("Test");
        Assert.assertEquals("Test", myService.showResult());
    }

    @Configuration
    static class MykServiceTestContextConfiguration {

        @Bean
        public MyService myService() {
            return new MyService();
        }

        @Bean
        public Utility utility() {
            return new Utility();
        }
    }

}