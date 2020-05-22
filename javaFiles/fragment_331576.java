env.put(Context.PROVIDER_URL, "http://your_host:port");
env.put(Context.SECURITY_PRINCIPAL, "username");
env.put(Context.SECURITY_CREDENTIALS, "password");
env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
InitialContext ctx = new InitialContext(env);
Destination queue = (Destination) ctx.lookup("jndi name of your queue");