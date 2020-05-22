private String provider = "";
private String jvmPort = "";
private JMXServiceURL jmxService = null;
private JMXConnector jmxConnector = null;
private RMIConnector rmiConnector = null;
private MBeanServerConnection beanServerConn = null;
.........

public boolean connectToJVM(String jvmURL, String user, String pass)
{
    boolean flag = false;
    beanServerConn = null ;  
    try
    {
        jmxService = new JMXServiceURL(jvmURL);
        Map environment = new HashMap();
        int jmxconnect_timeout = 30000;
        environment.put("jmx.remote.protocol.provider.pkgs",provider);
        if (jmxconnect_timeout > 0) {
            environment.put("jmx.remote.x.request.waiting.timeout", Long.toString(jmxconnect_timeout));
        }
        boolean registrySSL = false;

        if(user.equalsIgnoreCase("none")|| (pass.equalsIgnoreCase("none")))
        {
            try
            {
                jmxConnector = JMXConnectorFactory.connect(jmxService,environment);
            }
            catch(IOException ioe)
            {
                registrySSL = true;
            }
        }
        else
        {
            String [] credentials={user,pass};
            environment.put(JMXConnector.CREDENTIALS, credentials);
            try
            {
                jmxConnector = JMXConnectorFactory.connect(jmxService,environment);
            }
            catch(IOException ioe)
            {
                registrySSL = true;
            }
        }

        if(registrySSL)
        {
            /*
                This if block runs when the "management.properties" file contains 
                com.sun.management.jmxremote.registry.ssl=true

                This block of code is applicable both JDK5.0 & 6.0

                Only for JDK6.0
                ===============
                    environment.put("com.sun.jndi.rmi.factory.socket", new SslRMIClientSocketFactory());
                    beanServerConn = jmxConnector.getMBeanServerConnection();
            */

            try {
                MySslRMIClientSocketFactory csf = new MySslRMIClientSocketFactory(targetHost, Integer.parseInt(jvmPort), (int)jmxconnect_timeout);
                Registry registry = LocateRegistry.getRegistry(targetHost, Integer.parseInt(jvmPort), csf);
                RMIServer stub = (RMIServer) registry.lookup(jndiName);
                rmiConnector = new RMIConnector(stub, environment);
                rmiConnector.connect(environment);
                beanServerConn = rmiConnector.getMBeanServerConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            beanServerConn = jmxConnector.getMBeanServerConnection();
        }

        if(beanServerConn == null)
        {
            System.out.println("Connection to JVM is not established for url : " + url);
            return false;
        }
        else
        {
            flag = true;
        }
    }
    catch(Exception ex)
    {
        System.out.println("Connection to JVM is not established for url : " + url);
        //ex.printStackTrace();
        return false;
    }
    return flag;
}