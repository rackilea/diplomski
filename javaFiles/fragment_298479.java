public void expireSessionWithId(String sessionID)
{  
     try { 
        MBeanServer server = java.lang.management.ManagementFactory.getPlatformMBeanServer();

        ObjectName objectName=new ObjectName("jboss.web:type=Manager,path=/test,host=default-host");

        // declare signature of the parameter
        String[] sig = { "java.lang.String"};
        // declare parameter
        Object[] opArgs1 = { sessionID };
        // call the method
        String value = (String) server.invoke(objectName, "expireSession",
                opArgs1, sig);

        System.out.println(value);
    } catch (MalformedObjectNameException e) {
        //handle the exception
    } catch (InstanceNotFoundException e) {
        //handle the exception
    } catch (ReflectionException e) {
        //handle the exception
    } catch (MBeanException e) {
        //handle the exception
    }

}