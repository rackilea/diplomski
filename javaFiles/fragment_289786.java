public class UserIdentityMethodSecurityExpressionRoot 
    extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    public UserIdentityMethodSecurityExpressionRoot(Authentication authentication) {
        super(authentication);
    }

    public boolean userIdentity(Long userId) {
        User user = ((UserPrincipal) this.getPrincipal()).getUser();
        return user.getId() == userId;
    }
}