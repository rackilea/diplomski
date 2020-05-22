Properties p = new Properties();
p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
p.put("java.naming.provider.url", "http://tomcatserver:8080/openejb/ejb");
// user and pass optional
p.put("java.naming.security.principal", "myuser");
p.put("java.naming.security.credentials", "mypass");

InitialContext ctx = new InitialContext(p);

MyBean myBean = (MyBean) ctx.lookup("MyBeanRemote");