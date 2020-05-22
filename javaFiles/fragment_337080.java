import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;


public class Program {

    public static void main(String[] args) throws NamingException {
      Properties jndiProps = new Properties();
    jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,         
    "org.jboss.naming.remote.client.InitialContextFactory");
    jndiProps.put(Context.PROVIDER_URL,"remote://localhost:4447");
    jndiProps.put(Context.SECURITY_PRINCIPAL, "testuser");
    jndiProps.put(Context.SECURITY_CREDENTIALS, "testpassword");
    jndiProps.put("jboss.naming.client.ejb.context", true);
    Context ctx = new InitialContext(jndiProps);
    }

}