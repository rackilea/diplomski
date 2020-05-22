errorHandler(deadLetterChannel("direct:moveFailedMessage").useOriginalMessage());
from("direct:moveFailedMessage").to(ftpErrorURI+ftpOptions).process(new Processor() {
    public void process(Exchange exchange) throws Exception {
        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        exchange.getIn().setBody(cause.getMessage());
    }
}).to(sendMailURI).to(ftpErrorLogURI+ftpErrorOptions);