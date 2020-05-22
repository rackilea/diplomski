Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
if(null!=e && e instanceof HttpOperationFailedException)
        {
            HttpOperationFailedException httpOperationFailedException = (HttpOperationFailedException)e;
            responseCode=httpOperationFailedException.getStatusCode();
        }