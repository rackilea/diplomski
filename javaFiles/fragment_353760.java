public class LDAPConnectionClient {

    @Autowired
    LDAPConnectionSource source;

    public void doLDAPStuff() {
        LDAPConnection ldapConnection = source.getLDAPConnection();
        //do stuff with the connection
    }
}