@Service
@Profile("!integration")
public class LDAPService
{   
    @Autowired
    private LDAPServerConfig ldapServerConfig;

    private LDAPConnection ldapConnection;

    public LDAPConnection getLDAPConnection()
    {
          //some server config from  ldapServerConfig
          return ldapConnection;
    }
}