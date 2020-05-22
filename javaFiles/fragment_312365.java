@Entity
public class CustomUser implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        @ManyToMany(fetch = FetchType.EAGER)
        Collection<Authorities> authorities;
        String password;
        String userName;
        Boolean accountNonExpired;
        Boolean accountNonLocked;
        Boolean credentialsNonExpired;
        Boolean enabled;

        @Autowired
        @Transient
        BCryptPasswordEncoder passwordEncoder;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return userName;
        }

        @Override
        public boolean isAccountNonExpired() {
            return accountNonExpired;
        }

        @Override
        public boolean isAccountNonLocked() {
            return accountNonLocked;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return credentialsNonExpired;
        }

        @Override
        public boolean isEnabled() {
            return enabled;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setAuthorities(Collection<Authorities> authorities) {
            this.authorities = authorities;
        }

        public void setPassword(String password) {
            this.password = passwordEncoder.encode(password);
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setAccountNonExpired(Boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
        }

        public void setAccountNonLocked(Boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
        }

        public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }

    }