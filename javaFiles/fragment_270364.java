public class GetHttpSessionConfigurator extends
    ServerEndpointConfig.Configurator {


@Override
public void modifyHandshake(ServerEndpointConfig config,
        HandshakeRequest request, HandshakeResponse response) {
    config.getUserProperties().put("UserPrincipal",request.getUserPrincipal());
    config.getUserProperties().put("userInRole", request.isUserInRole("someRole"));  
}}