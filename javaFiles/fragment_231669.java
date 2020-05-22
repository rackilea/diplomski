public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {

    ...
    if (methodName.equals(CREATE)) {
        return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).create(null, null, null, null, null)).buildAndExpand(pathVariables);
    }
    ... 
}