public Collection<GrantedAuthority> getAuthorities(Integer access) {
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

    if (access.compareTo(1) == 0) {
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
    else{
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    return authList;
}