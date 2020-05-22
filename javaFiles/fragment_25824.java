@WebService(
      portName = "CallBackWs",
      serviceName = "CallBackWsService", 
      targetNamespace = "http://test.server.callback.ws/", 
      endpointInterface = "org.test.CallBackWs") 
   public class ClassCallBackWsImpl implements ClassCallBackWs{    
       public void event(ClassParameter event) throws Exception { 
       } 
   }