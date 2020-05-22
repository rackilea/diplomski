import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb.client.ContextSelector;
import org.jboss.ejb.client.EJBClientConfiguration;
import org.jboss.ejb.client.EJBClientContext;
import org.jboss.ejb.client.PropertiesBasedEJBClientConfiguration;
import org.jboss.ejb.client.remoting.ConfigBasedEJBClientContextSelector;

import ro.asf.capone.ejb.beans.security.SecurityControllerRemote;


public class AppJboss {
    public static void main(String[] args) throws NamingException {
       System.out.println("Hello World!");
       final String lookup = "ejb:agency-ear/agency-ejb//SecurityControllerBean!ro.asf.capone.ejb.beans.security.SecurityControllerRemote";

       final Properties clientProperties = new Properties();
       clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_DISALLOWED_MECHANISMS",
            "JBOSS-LOCAL-USER");
       clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOPLAINTEXT",
            "false");
       clientProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
       clientProperties.put("remote.connections", "default");
       clientProperties.put("endpoint.name", "client-endpoint");
       clientProperties.put("remote.connection.default.port", "4447");
       clientProperties.put("remote.connection.default.host", "127.0.0.1");
       clientProperties.put("remote.connection.default.username", "capone");
       clientProperties.put("remote.connection.default.password", "c4ca4238a0b923820dcc509a6f75849b");
       clientProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS",
            "false");

       final EJBClientConfiguration ejbClientConfiguration = new PropertiesBasedEJBClientConfiguration(
            clientProperties);
       final ContextSelector<EJBClientContext> contextSelector = new ConfigBasedEJBClientContextSelector(
            ejbClientConfiguration);
       EJBClientContext.setSelector(contextSelector);

       final Properties properties = new Properties();
       properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
       final Context context = new InitialContext(properties);
       final SecurityControllerRemote myBean = (SecurityControllerRemote) context.lookup(lookup);
       final long result = myBean.getServerTimeMillis();
       System.out.println("result " + result);

       new Thread(new Runnable() {

          public void run() {
              final long result = myBean.getServerTimeMillis();
              System.out.println(result);
          }
       }).start();
    }
}