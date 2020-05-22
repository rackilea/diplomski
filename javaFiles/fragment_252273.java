@Override
public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
    String dBuserName = activeUserInfo.getUserName();
    if(dBuserName == null){
        throw new UsernameNotFoundException("User not authorized.");
    }
    GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
    UserDetails userDetails = (UserDetails)new User(dBuserName,
            activeUserInfo.getPassword(), Arrays.asList(authority));
    return userDetails;
}