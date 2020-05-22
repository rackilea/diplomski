public class UserCredentialsConnectionFactoryAdapter extends org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter {

    private JndiTemplate jndiTemplate;

    public void setJndiTemplate(JndiTemplate jndiTemplate) {
        this.jndiTemplate = jndiTemplate;
    }

    @Override
    protected Connection doCreateConnection(String username, String password) throws JMSException {
        wlFix();
        return super.doCreateConnection(username, password);
    }

    /**
     * Associate JNDI variables (user and password) with this thread for the
     * benefit of the WL drivers.
     */
    protected void wlFix() {
        try {
            @SuppressWarnings("unused")
            InitialContext initialContext = new InitialContext(jndiTemplate.getEnvironment());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

}