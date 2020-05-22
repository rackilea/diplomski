@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authenticationDetailsSource(myAuthenticationDetailsSource())/* and all the missiong HTTP configuration*/;
    }

    @Bean
    private AuthenticationDetailsSource<HttpServletRequest, MyWebAuthenticationDetails> myAuthenticationDetailsSource() {
        return new MyAuthenticationDetailsSource<HttpServletRequest, MyWebAuthenticationDetails>();
    }

    private final class MyAuthenticationDetailsSource extends AuthenticationDetailsSourceImpl<HttpServletRequest, MyWebAuthenticationDetails> {

        @Autowired
        private AuthenticationProperties authenticationProperties;

        @Override
        public MyWebAuthenticationDetails buildDetails(HttpServletRequest request) {
            return new MyWebAuthenticationDetails(request, this.authenticationProperties);
        }
    }
}