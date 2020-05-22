int i = 0;
Response response;
while (true) {
    try {
        response = webtarget.request().get();
        break;
    } catch (ProcessingException e){
        if (e.getCause() instanceof SocketTimeoutException && i < retryNumber) {
            i++;
        } else {
            // throws some exception
        }
    }
}