@WebMvcTest(controller = MyController.class)
public MyControllerTest {

    @Configuration
    public class MyTestsSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            //...
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //...
        }
    }

    @Test
    public void simpleTest() {
    }
}