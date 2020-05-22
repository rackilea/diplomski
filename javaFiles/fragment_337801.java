class RequestProcessor {
    public Object submitRequest() {
        String correlationId = new ExternalService().send();

        return new ResultReceiver().register(correlationId).join();
    }
}