@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private CustomAuthProvider customAuthProvider;
@Override
protected void configure(HttpSecurity http) throws Exception {
    // everyone is allowed tp view login page
    http.authorizeRequests().antMatchers("/login").permitAll().and();
    http.authorizeRequests().antMatchers("custom_base_path" + "**").authenticated().and().
    formLogin().loginPage("/loginForm).loginProcessingUrl("/loginUser")
            .usernameParameter("username").passwordParameter("password")
            .defaultSuccessUrl("custom_base_path+ "home", true);

@Autowired
public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(customAuthProvider);
}


//CustomAuthProvider
@Component
public class CustomAuthentiationProvider implements AuthenticationProvider{
@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String userid = authentication.getName();
    String password = authentication.getCredentials().toString();
    Authentication auth = null;
    try {
 //write your custom logic to match username, password
boolean userExists = your_method_that_checks_username_and_password
        if(userExists ){
            List<Role> roleList= roleDao.getRoleList(userid);
            if (roleList == null || roleList.isEmpty()) {
                throw new NoRoleAssignedException("No roles is assigned to "+userid);
            }
            auth = new UsernamePasswordAuthenticationToken(userid, password,getGrantedAuthorities(roleList));
        }
    } catch (Exception e) {
        log.error("error", e);
    }
    return auth;

}

@Override
public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
}

public List<GrantedAuthority> getGrantedAuthorities(List<Role> roleList) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (Role role : roleList) {
        authorities.add(new SimpleGrantedAuthority(role.getRoleName());
    }
    return authorities;
}
}