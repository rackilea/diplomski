public class SslLdap extends LdapContextSource{

this.setUrl("ldaps://url:636");

System.setProperty("javax.net.ssl.trustStore", ctx.getRealPath( "WEB-INF/truststore.jks" ));
    System.setProperty("javax.net.ssl.trustStorePassword", keyStorePassword);    


    super.afterPropertiesSet();

    Hashtable<String, Object> envProps = new Hashtable<String, Object>();

    envProps.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    envProps.put(Context.PROVIDER_URL, "ldaps://url:636");
    envProps.put(Context.SECURITY_AUTHENTICATION, "simple");
    envProps.put(Context.SECURITY_PRINCIPAL, "userDN");
    envProps.put(Context.SECURITY_CREDENTIALS, "pass"); 


    envProps.put("java.naming.security.protocol", "ssl");
    envProps.put("com.sun.jndi.ldap.connect.pool", "true");

    super.setBaseEnvironmentProperties(envProps);
    super.afterPropertiesSet();

}