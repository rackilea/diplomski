public class StartupBeanExtension implements Extension, ServletExtension {
    @Override
    public void handleDeployment(DeploymentInfo deployment, ServletContext context) {
        boolean sessionPersistenceEnabled = Boolean.parseBoolean(BeanUtils.getBean(PropertyResolver.class).getValue("UAM.SessionPersistenceEnabled"));
        if (sessionPersistenceEnabled) {
            System.out.println("Overriding default InMemorySessionManager...[" + deployment.getDeploymentName() + ", " + deployment.getDisplayName() + "]");
            deployment.setSessionManagerFactory(new UAMSessionManagerFactory());
        } else {
            System.out.println("InMemorySessionManager IS NOT OVERIDED!");
        }
    }    
}

public class UAMSessionManagerFactory implements SessionManagerFactory {
    @Override
    public SessionManager createSessionManager(Deployment deployment) {
        UAMSessionManager ss = new UAMSessionManager(deployment.getDeploymentInfo().getDeploymentName());
        return ss;
    }
}

public class UAMSessionManager extends InMemorySessionManager {

    public UAMSessionManager(String deploymentName) {
        super(deploymentName);

        UAMSessionListener uamSessionListener = new UAMSessionListener();
        super.registerSessionListener(uamSessionListener);

        System.out.println("New session manager created. Listener activated.");
    }

    // create session
    public Session createSession(final HttpServerExchange serverExchange, final SessionConfig config, String sessionID) {
        config.setSessionId(serverExchange, sessionID);
        Session session = super.createSession(serverExchange, config);
        return session;
    }

    // get session
    public Session getSession(final HttpServerExchange serverExchange, final SessionConfig config) {
        final String sessionId = config.findSessionId(serverExchange);
        Session session = getSession(sessionId);

        if (session == null) {
            // DO SOMETHING TO CREATE SESSION OR RESTORE IT FROM DB
            try {
                UAMService uam = getUAMService();
                if (uam != null) {
                    Sessions storedSession = uam.getSession(sessionId);

                    if (storedSession != null) {
                        String storedSessionId = storedSession.getSessionId();
                        // create new session with storedSessionID
                        session = createSession(serverExchange, config, storedSessionId);

                        // SET session attributes if needed from storedSession to new one

                    } else {
                        // let InMemorySessionManager create new session
                        return null;
                    }
                }
            } catch (Exception ex) {

            }
        }

        return session;
    }
}

public class UAMSessionListener implements SessionListener {

    @Override
    public void sessionCreated(Session session, HttpServerExchange exchange) {

    }

    @Override
    public void sessionDestroyed(Session session, HttpServerExchange exchange, SessionDestroyedReason reason) {

    }

    @Override
    public void attributeAdded(Session session, String name, Object value) {
        UAMService uamService = getUAMService();

        if (uamService != null) {
            Sessions storedSession = uamService.getSession(session.getId());
            boolean isNew = false;
            if (storedSession == null) {
                storedSession = new Sessions();
                storedSession.setSessionId(session.getId());
                storedSession.setActvityDate(new Date());
                isNew = true;
            }

            // STORE SOME INFO FROM value and update/create it in storage
            uamService.updateSession(storedSession, isNew);
        }
    }

    @Override
    public void attributeUpdated(Session session, String name, Object newValue, Object oldValue) {

    }

    @Override
    public void attributeRemoved(Session session, String name, Object oldValue) {

    }

    @Override
    public void sessionIdChanged(Session session, String oldSessionId) {

    }
}