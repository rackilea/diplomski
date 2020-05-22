private OperationPreprocessor maskPassword() {
    return new PasswordMaskingPreprocessor();
}

private static class PasswordMaskingPreprocessor implements OperationPreprocessor {

    @Override
    public OperationRequest preprocess(OperationRequest request) {
        Parameters parameters = new Parameters();
        parameters.putAll(request.getParameters());
        parameters.set("password", "XXX");
        return new OperationRequestFactory().create(request.getUri(),
                request.getMethod(), request.getContent(), request.getHeaders(),
                parameters, request.getParts());
    }

    @Override
    public OperationResponse preprocess(OperationResponse response) {
        return response;
    }

}