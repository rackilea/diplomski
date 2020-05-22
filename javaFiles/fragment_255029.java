@Service("assembler")
public class Assembler {
    @Transactional(readOnly = true)
    User buildUserFromUserEntity(Person userEntity) {
        String username = userEntity.getUsername().toLowerCase();
        String password = userEntity.getPassword();

        boolean enabled = userEntity.isEnabled();
        boolean accountNonExpired = userEntity.isAccountNonExpired();
        boolean credentialsNonExpired = userEntity.isCredentialsNonExpired();
        boolean accountNonLocked = userEntity.isAccountNonLocked();

        Collection<GrantedAuthority> authorities = new ArrayList<>();
// I am manually assigniing role below as we dont have complex role management. 
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}