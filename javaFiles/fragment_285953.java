WebClient.getConfig(client).getBus().getProperties().put("org.apache.cxf.logging.FaultListener",new MyFaultListener());

public class MyFaultListener implements FaultListener{
    public boolean faultOccurred(final Exception exception,final String description,final Message message) {
        //return false to avoid warning of default CXF logging interceptor
        return false;
    }
}