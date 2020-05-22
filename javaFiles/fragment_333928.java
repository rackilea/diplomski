public class LogbackInterceptor implements ClientInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LogbackInterceptor .class);


     public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
           logger.debug("Sent request [" + messageContext.getRequest() + "]");
           return true;
     }

     public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
           logger.debug("Received response [" + messageContext.getResponse() + "] for request [" +
                                messageContext.getRequest() + "]");
           return true;
}

.....
}