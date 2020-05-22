@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repo.findOneByUserName(username);

    if(user == null) {
        throw new UsernameNotFoundException(username);
    }
    if(requireActivation && !user.getToken().equals("1")) {
        Application.log.error("User [" + username + "] tried to log in, but his account is not activated.");
        throw new UsernameNotFoundException(username + " did not activate his account.");
    }
    httpSession.setAttribute(CURRENT_USER_KEY, user);
    List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());

    return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), auth);
}