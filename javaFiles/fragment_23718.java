import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ConfigurationTest {
    @Autowired
    private Environment environment;

    @Test
    public void test1() throws Exception {
        System.out.println(environment.getProperty("bhavya",Boolean.class));
    }

    @Configuration
    @ComponentScan(basePackages={"com.example.demo.test"})
    public static class EnvironmentServiceTestConfiguration{

        @Bean
        @Primary
        public Environment environment(){
            Environment env =  Mockito.mock(Environment.class);
            when(env.getProperty(eq("bhavya"), eq(Boolean.class))).thenReturn(true);

            return env;
        }
    }
}