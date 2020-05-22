public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getPrincipal() + "";
    String password = authentication.getCredentials() + "";

    User user = userRepo.findOne(username);
    if (user == null) {
        throw new BadCredentialsException("1000");
    }
    if (!encoder.matches(password, user.getPassword())) {
        throw new BadCredentialsException("1000");
    }
    if (user.isDisabled()) {
        throw new DisabledException("1001");
    }
    List<Right> userRights = rightRepo.getUserRights(username);
    return new UsernamePasswordAuthenticationToken(username, null, userRights.stream().map(x -> new SimpleGrantedAuthority(x.getName())).collect(Collectors.toList()));
}