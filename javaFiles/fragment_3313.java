import org.apache.cxf.message.Message;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.endpoint.Client;


    public void someMethod() {
        try {
            wsClient.getSomeInfo(); //exception here for non-2xx http status by default
        } finally {
           Client client = ClientProxy.getClient(wsClient);
           Integer responseCode = client.getResponseContext().get(Message.RESPONSE_CODE);  
        }