...
@Override
protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
    super.addCustomAuthorities(username, authorities);

    List<GrantedAuthority> additional = new ArrayList<GrantedAuthority>();
    for (GrantedAuthority role : authorities) {
        additional .addAll(vourMappingService.getAdditionalForRole(role));
    }
    authorities.addAll(additional );
}