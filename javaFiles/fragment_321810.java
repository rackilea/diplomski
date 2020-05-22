import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
...

URL wsdl = getClass().getResource("wsdl/greeting.wsdl");
SOAPService service = new SOAPService(wsdl, serviceName);
Greeter greeter = service.getPort(portName, Greeter.class);

// Okay, are you sick of configuration files 
 // This will show you how to configure the http conduit dynamically
Client client = ClientProxy.getClient(greeter);
HTTPConduit http = (HTTPConduit) client.getConduit();

HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

httpClientPolicy.setConnectionTimeout(36000);
httpClientPolicy.setAllowChunking(false);
httpClientPolicy.setReceiveTimeout(32000);

http.setClient(httpClientPolicy);

...
  greeter.sayHi("Hello");