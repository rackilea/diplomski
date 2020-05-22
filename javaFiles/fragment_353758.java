@Service
@Profile("integration")
public class LdapInMem implements LDAPConnectionSource
{
    InMemoryDirectoryServer server;

    @PostConstruct
    public void startInMemLdapServer() throws UnknownHostException
    {
           //some in memory listener config
    }

    public LDAPConnection getLDAPConnection() {
        return server.getConnection();  // or what ever returns a LDAPConnection
    }
}