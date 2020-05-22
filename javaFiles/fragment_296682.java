public class ServiceMyInterceptor extends AbstractSoapInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMyInterceptor.class);

    public ServiceMyInterceptor() {
        super(Phase.USER_PROTOCOL);
        addAfter(ReadHeadersInterceptor.class.getName());
        addAfter(EndpointSelectionInterceptor.class.getName());
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        Map<String, List<String>> headers = CastUtils.cast((Map)message.get(Message.PROTOCOL_HEADERS));
        if (headers != null) {
            List<String> sa = headers.get("SOAPAction");
            String action = null;
            if (sa != null && sa.size() > 0) {
                action = sa.get(0);
            }
            LOGGER.info("Remove SOAPAction who equals {}", action);
            headers.remove("SOAPAction");
        }
    }
}