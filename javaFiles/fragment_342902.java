public class MyLdapServer 
implements ServerConnectionFactory<LDAPClientContext, Integer> {

private LDAPListener listener;

public void init() {
    try {
        listener = new LDAPListener(1389, this);
    } catch (IOException e) {
        logger.error("error opening LDAP listener", e);
    }
}

public void destroy() {
   listener.close();
}

@Override
public ServerConnection<Integer> handleAccept(LDAPClientContext context)
        throws ErrorResultException {
    if (logger.isDebugEnabled())
        logger.debug("ldap connection from: " + context.getPeerAddress());

    IncomingLdapConnection ilc = new IncomingLdapConnection(context);
    return ilc;
}

private static Logger logger = LoggerFactory.getLogger(MyLdapServer.class);

}