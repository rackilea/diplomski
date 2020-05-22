private <R extends RequestBase, S extends ResponseBase> void serviceCall(
        R request,
        S response,
        ADelegate delegate
) {
    JsonClient<R, S> client = new JsonClient<R, S>(request.ServiceServerUrl, request, response);
    client.sendRequest(delegate);
}