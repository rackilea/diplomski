public void process(Exchange exchange) throws Exception {
    HttpOperationFailedException cause = (HttpOperationFailedException) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        exchange.getIn().setHeader("FailedBecause", cause.getMessage());
        exchange.getIn().setHeader("ResponseBody", cause.getResponseBody());

}