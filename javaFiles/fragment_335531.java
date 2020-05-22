public class CustomService implements UserDetailsService {
   @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {

        Account account = accountDAO.findAccountByName(username);

        if (account == null) {
            throw new UsernameNotFoundException("account name not found");
        }
        return buildUserFromAccount(account);
    }


    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    private User buildUserFromAccount(Account account) {

        String username = account.getUsername();
        String password = account.getPassword();
        boolean enabled = account.getEnabled();
        boolean accountNonExpired = account.getAccountNonExpired();
        boolean credentialsNonExpired = account.getCredentialsNonExpired();
        boolean accountNonLocked = account.getAccountNonLocked();

        // additional information goes here
        String companyName = companyDAO.getCompanyName(account);


        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        CustomUserDetails user = new CustomUserDetails (username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                authorities, company);

        return user;
    }


public class CustomUserDetails extends User{

    // ...
    public CustomUserDetails(..., String company){
         super(...);
         this.company = company;
    }

    private String company;

    public String getCompany() { return company;}

    public void setCompany(String company) { this.company = company;}
}