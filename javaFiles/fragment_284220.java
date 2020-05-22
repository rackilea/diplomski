import javax.naming.NamingException;


public class LdapQuery {
    public static void main(String[] args) throws NamingException {
        SimpleLdapAuthentication obj = new SimpleLdapAuthentication();
        obj.ldapquery();
    }

}