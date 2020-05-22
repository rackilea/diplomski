public static void checkUserIdentity(Long userId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    // user did not provide a token
    if(auth == null) {
        throw new AccessDeniedException(); 
    }      
    UserDetails details = (UserDetails) auth.getPrincipal();
    if(userId != details.getId()) {
        throw new AccessDeniedException(); 
    }
}