package at.rovo.test.httpclient;

import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.security.Constraint;

public class JettyServer 
{
    private String REALM;

    public static void main( String[] args ) throws Exception
    {
        new JettyServer();
    }

    public JettyServer() throws Exception
    {
        Server server = new Server(8080);
        server.addConnector(this.getSslChannelConnector(server));
        server.setStopAtShutdown(true);

        // create the context handler for the server        
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setClassLoader(Thread.currentThread().getContextClassLoader());
        // attach the security handler to it that has basic authentication
        context.setSecurityHandler(this.getSecurityHandler());

        server.setHandler(context);
        // define the processing servlet
        context.addServlet(new ServletHolder(new ProcessingServlet()), "/process");

        server.start();
        server.join();
    }

    private Connector getSslChannelConnector(Server server)
    {
        try
        {           
            String keyStore = this.getClass().getResource("/serverKey.jks").toURI().getPath();

            SslConnectionFactory sslConnFactory = new SslConnectionFactory();
            sslConnFactory.getSslContextFactory().setKeyStorePath(keyStore);
            sslConnFactory.getSslContextFactory().setKeyStorePassword("keystorePW");
            sslConnFactory.getSslContextFactory().setKeyManagerPassword("jettyPW");

            HttpConfiguration config = new HttpConfiguration();
            ConnectionFactory connFactory = new HttpConnectionFactory(config);

            ServerConnector connector = new ServerConnector(server, sslConnFactory, connFactory);
            connector.setPort(8443);
            connector.setHost("localhost");
            connector.setIdleTimeout(30000);
            return connector;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private SecurityHandler getSecurityHandler() throws Exception 
    {
        // add authentication
        Constraint constraint = new Constraint(Constraint.__BASIC_AUTH,"user");
        constraint.setAuthenticate(true);
        constraint.setRoles(new String[]{"user","admin"});

        // map the security constraint to the root path.
        ConstraintMapping cm = new ConstraintMapping();
        cm.setConstraint(constraint);
        cm.setPathSpec("/*");

        // create the security handler, set the authentication to Basic
        // and assign the realm.
        ConstraintSecurityHandler csh = new ConstraintSecurityHandler();
        csh.setAuthenticator(new BasicAuthenticator());
        csh.setRealmName(REALM);
        csh.addConstraintMapping(cm);

        // set the login service
        csh.setLoginService(getHashLoginService());

        return csh;
    }

    private HashLoginService getHashLoginService() throws Exception 
    {
        // load the authentication data from a simple property file
        HashLoginService hls = new HashLoginService();
        hls.setName(REALM);
        hls.setConfig(this.getClass().getResource("/realm.properties").toURI().toString());
        hls.setRefreshInterval(0);
        return hls;
    }
}