public class MyApp extends ResourceConfig {
    public MyApp() {
        property(ServletProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }
}

public class MyApp extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.server.response.setStatusOverSendError", true);
        return props;
    }
}