public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username=(String)authentication.getPrincipal();
    User user=null;
    if(username!=null){
        user=getUserRepository().findByUserName(username);
        if(user!=null){
            if(user.getEnabled()!=0){
                if((user.getUserDetail().getConfirmed()!=0)||((new Date().getTime()-user.getUserDetail().getRequestDate().getTime())/(1000 * 60 * 60 * 24))<=getUnconfirmedDays()){
                    if(getPasswordEncoder().isPasswordValid(user.getPassword(), (String)authentication.getCredentials(), user)){
                        user.authenticated=true;
                        user.getAuthorities();
                    } else {
                        throw new BadCredentialsException("Password incorrect");
                    }
                }else{
                    throw new UserNotConfirmedAndTimeExceeded("User has not been cofirmed in the established time period");         
                }
            }else{
                throw new DisabledException("User is disabled");
            }
        }else{
            throw new BadCredentialsException("User does not exist");
        }
    }else{
        throw new AuthenticationCredentialsNotFoundException("No credentials found in context");
    }
    return user;
}