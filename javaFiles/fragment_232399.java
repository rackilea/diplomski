public static class ClientFallbackFactory implements MyServiceFeignClient, FallbackFactory<ClientFallbackFactory> {

    @Override
    public ClientFallbackFactory create(Throwable cause) {
        return new PRSClientFallback(cause);
    }

    final Throwable cause; // nullable

    public ClientFallbackFactory() {
        this(null);
    }

    ClientFallbackFactory(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public PaymentRiskServiceResponse sendOrder(String content) {
        String errorMessage = (cause == null) ? "No cause returned" : cause.getMessage();
        LOG.debug("Client fallback called : {} ", errorMessage);
        MyServiceResponse response = new MyServiceResponse();
        response.setResultStatus("WARN");
        response.setErrorMessage("Client fallback called");
        return response;
    }
}