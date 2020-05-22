public <T extends IModel> T makeCall(Object payload, Endpoint<T> endpoint) throws UserException {
    ...
    ResponseEntity<T> response = restTemplate.postForEntity(endpoint.getEndpointUrl(), payload, endpoint.getReturnType());
    if (response.getBody().isError()) {
        throw response.getBody().getError();
    }
    ...
    return response.getBody();
}