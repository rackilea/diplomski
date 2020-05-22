public class AuthProviderImpl implements AuthenticationProvider 
 {
      @Override
   public Authentication authenticate(Authentication authentication)
     throws AuthenticationException 
        {
          WebServiceAuthClient client = //get an handle to your web service
          //get user name, password from authenticate object
          client.autheticat(username, pwd);
        }

 }