private List<SimpleGrantedAuthority> buildSimpleGrantedAuthority(
        final UserVO userVO) {
    List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
    if (userVO.getRoleVO() != null) {
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+userVO
                .getRoleVO().getRoleName()));
    }
return grantedAuthorities;
}