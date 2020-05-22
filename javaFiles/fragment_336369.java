@Configuration
public class LdapConfiguration {

    @Bean
    public LdapContextSource contextSource(){
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl("ldap://companyurl.com:389");
        contextSource.setUserDn("CN=serviceaccount,OU=Service Accounts,DC=ad,DC=company,DC=com");
        contextSource.setPassword("secretpassword");
        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate(){
        LdapTemplate template = new LdapTemplate(contextSource());
        return template;
    }
}