package cucumber.examples.spring.txn;

import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureMockMvc
public class CucumberContextConfiguration  {

    @Value("${key}")
    private String value;

    @Before
    public void setup_cucumber_spring_context(){
        // Dummy method so cucumber will recognize this class as glue
        // and use its context configuration.

        System.out.println("Property was " + value);
    }
}