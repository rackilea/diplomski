@Component
public class CredentialMaskingLoggingOutInterceptor extends LoggingOutInterceptor{

    @Autowired
    ApplicationProperties appProps;

    /**
     * To mask user credentials from the logging so that which will not be misused.
     */
    @Override
    protected String formatLoggingMessage(LoggingMessage buffer) {
        return buffer.toString().replace(appProps.getUsername(), "SOAP_USERNAME").replace(appProps.getPassword(), "SOAP_PASSWORD");
    }
}