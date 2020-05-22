@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin().loginPage("/login").defaultSuccessUrl("/").permitAll() // http://docs.spring.io/spring-security/site/docs/4.0.3.RELEASE/reference/htmlsingle/#jc-form
                .and()
            .logout().permitAll(); // http://docs.spring.io/spring-security/site/docs/4.0.3.RELEASE/reference/htmlsingle/#jc-logout
    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web
            .ignoring()
                .antMatchers("/resources/**"/*, ... */);
    }
}

@Controller
public class LoginController
{
    @RequestMapping("/login")
    static String login(Model model)
    {
        return "login";
    }
}