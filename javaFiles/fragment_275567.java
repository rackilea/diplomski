public class User implements UserDetails{

private UserData userData;
private List<String> roles;

public User(UserData user){
    this.userData=user;

}



public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
    for (String role : userData.getRoles()) {
        authorities.add(new SimpleGrantedAuthority(role));
    }
    return authorities;
}

public String getPassword() {
    return user.getPassword();
}

public String getUsername() {
    // TODO Auto-generated method stub
    return user.getUsername();
}

public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
}

public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
}

public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
}

public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
}