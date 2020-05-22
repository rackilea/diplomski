@Scope(APPLICATION)
@Name("org.jboss.seam.web.authenticationFilter")
@Install(value = false, precedence = BUILT_IN)
@BypassInterceptors
@Filter(within = "org.jboss.seam.web.exceptionFilter")
public class CustomAuthenticationFilter extends org.jboss.seam.web.AbstractFilter {

    /** 
      * Because of some private methods defined in AuthenticationFilter
      * do Ctrl + C / Ctrl + V All of source code of AuthenticationFilter
      *
      * Except authenticate method which is shown bellow
      */

    private void authenticate(HttpServletRequest request, final String username) throws ServletException, IOException {
        new ContextualHttpServletRequest(request) {

            @Override
            public void process() throws ServletException, IOException, LoginException {
                Identity identity = Identity.instance();
                identity.getCredentials().setUsername(username);

                try {
                    identity.preAuthenticate();

                    /**
                      * Yes, THE SAME LOGIC performed by authenticate-method must goes here
                      */

                    /**
                      * Do not use @In-jection here
                      * 
                      * Use context lookup instead
                      * For instance, UserService userService = (UserService) Contexts.lookupInStatefulContexts("userService");
                      */

                    identity.postAuthenticate();
                } finally {
                    // Set password to null whether authentication is successful or not
                    identity.getCredentials.setPassword(null);    
                }
            }
        }.run();  
    }

}