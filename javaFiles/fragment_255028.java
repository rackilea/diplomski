@Transactional
@Service("userDetailsService")
public class LoginServiceImpl implements UserDetailsService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private Assembler assembler;

    public LoginServiceImpl() {
    }
    @Override
// below you can pass as username also. And the the dao method will be responsible to search phonenumber, emailid, birthdate, blood group, DNA encoding, depending how sophisticated your database search is. 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Person person = personDAO.findPersonByUsername(username.toLowerCase());
        if (person == null) {
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return assembler.buildUserFromUserEntity(person);
    }
}