@Stateless
@Remote
@WebService(portName = "MyBeanPort",
    serviceName = "MyBeanService",
    targetNamespace = "http://superbiz.org/wsdl"
    endpointInterface = "org.superbiz.MyBeanRemote")
public class MyBean implements MyBeanRemote {
    //...
}

public interface MyBeanRemote {
   // any methods you want remotely invoked
}