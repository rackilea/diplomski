@WebService(targetNamespace = "http://tempuri.org/", name = "MyService")

@EndpointProperties(value = {
        @EndpointProperty(key = "webservice.security.authMethod", value = "WS-SECURITY")
        @EndpointProperty(key = "ws-security.callback-handler", value = "org.tempuri.ServerPasswordCallback")
    }
)


public interface MyService {
...
}