@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@SpringBootApplication
@SpringApplicationConfiguration( classes = {
        MockServletContext.class,
        HttpSessionConfig.class,
        WebSecurityConfig.class,
        Application.class
} )
public class HeadersTest {