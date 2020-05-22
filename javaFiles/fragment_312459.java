@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class MyControllerTest {

    @Configuration
    @EnableWebMvc // <------------ added this
    public static class MyControllerTestConfiguration {

        @Bean
        public SetupController setupController() {
            return new MyController();
        }

    }