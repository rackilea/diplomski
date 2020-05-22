public class CustomPostAuthenticationChecks implements UserDetailsChecker {

        public void check(UserDetails userDetails) {

            CustomUser customUser = (CustomUser) userDetails;
            if (customUser.needsEmailAuthentication()) {
                // Get rid of any authorities the user currently has
                userDetails.getAuthorities().clear();
                // Set the new authority, only allowing access to the 
                // email authentication page.
                userDetails.getAuthorities().add(new GrantedAuthorityImpl("ROLE_NEEDS_EMAIL_AUTH"));
            } else {
                userDetails.getAuthorities().add(new GrantedAuthorityImpl("ROLE_AUTHORIZED_USER"));
            }
    }