User existingUser = this.userDao.getUserByUsername(username);
if (existingUser != null) {
    List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
    roles.add(Role.USER);

    org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
            existingUser.getUsername(), existingUser.getPassword(), existingUser.getEnable(), true, true, true, roles);
    return user;
} else {
    throw new UsernameNotFoundException("User not found");
}