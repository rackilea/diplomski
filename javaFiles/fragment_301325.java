@Service
public class CustomWebServiceImpl extends WebServiceGatewaySupport implements CustomWebService {
    private static final int CONNECTION_TIMEOUT = (10 * 1000);
    private static final int READ_TIMEOUT = (10 * 1000);

    public CustomWebServiceImpl() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(CONNECTION_TIMEOUT);
        requestFactory.setReadTimeout(READ_TIMEOUT);
        setMessageSender(new ClientHttpRequestMessageSender(requestFactory));
    }

    (...)
}