public void grantUserAccess(User user) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication auth = securityContext.getAuthentication();
    user.getAuthorities().clear();
    user.getAuthorities().add(new GrantedAuthorityImpl("ROLE_AUTHORIZED_USER"));
    Authentication newAuth = new UsernamePasswordAuthenticationToken(user, auth.getCredentials(), user.getAuthorities());
    securityContext.setAuthentication(newAuth);
}