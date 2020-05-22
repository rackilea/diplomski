public static void main(String[] args) {
    Server server = new Server();

    //Enable parsing of jndi-related parts of web.xml and jetty-env.xml
    ClassList classlist = ClassList.setServerDefault(server);
    classlist.addAfter(
            "org.eclipse.jetty.webapp.FragmentConfiguration", 
            "org.eclipse.jetty.plus.webapp.EnvConfiguration", 
            "org.eclipse.jetty.plus.webapp.PlusConfiguration");
...
...
server.start();