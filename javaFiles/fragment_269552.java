public class ChatHandlerConfigurator extends ServerEndpointConfig.Configurator
{
    @Override
    public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response)
    {
        Map<String, List<String>> map = request.getParameterMap();
        if (!map.containsKey("path")) {
            throw new IllegalArgumentException("path was not provided");
        }

        // Optionally add values to userProperties
        Map<String, Object> userProperties = config.getUserProperties();
        userProperties.put("path", map.get("path").get(0));
    }
}