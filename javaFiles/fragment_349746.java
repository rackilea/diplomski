@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountDao.findAccountByEmail(email);
        System.out.println("User " + account );

        if(account == null ) {
            throw new UsernameNotFoundException(
                    "User " + email + " was not found in database");
        }

        return (UserDetails) account;
    }
}