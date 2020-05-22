@SubscribeMapping("/foo")
    public void handleWithError() {
        throw new IllegalArgumentException("Bad input");
    }

    @MessageExceptionHandler
    @SendToUser("/queue/error")
    public String handleException(IllegalArgumentException ex) {
        return "Got error: " + ex.getMessage();
    }