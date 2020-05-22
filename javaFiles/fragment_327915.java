public class LoginSuccessEventlistener extends EventListener {  

    @Override  
    public boolean canHandle(Object event) {  
        return event instanceof AuthenticationFailureBadCredentialsEvent;
    }  

    @Override  
    public void handle(Object event) {
AuthenticationFailureBadCredentialsEvent loginFailureEvent = (AuthenticationFailureBadCredentialsEvent) event;
        Object name = loginFailureEvent.getAuthentication().getPrincipal();

        if(principal instanceof org.springframework.security.userdetails.ldap.LdapUserDetailsImpl){
            out.("LDAPUser: " + user.getUsername() + " failed login");
//do you thing here
        }
    }    
}