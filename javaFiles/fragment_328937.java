List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
for (Role role : getRoles()) {
    simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().name()));
}

return simpleGrantedAuthorities;