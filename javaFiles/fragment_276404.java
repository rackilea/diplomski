@Component
public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {


    @Autowired
    public CustomBasicAuthenticationFilter(final AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void onSuccessfulAuthentication(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response, final Authentication authResult) {
        //Generate Token
        //Save the token for the logged in user
        //send token in the response
        response.setHeader("header-name" , "token");


    }

}