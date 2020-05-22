@Override
@Transactional(readOnly = true)
public UserDetails loadUserByUsername(String username) {

    User user = userRepository.findByUsername(username);

    if(user == null) throw new UsernameNotFoundException(username);

    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    for (Role role : user.getRoles()) {

        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

    }

    return new org.springframework.security.core.userdetails.User(user.getUsername(), 
            user.getPassword(), user.getEnabled(), user.getNonExpired(), 
            user.getCredentialsNonExpired(), user.getNonLocked(), grantedAuthorities);

}