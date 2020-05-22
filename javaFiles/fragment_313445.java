public ApiGatewayResponse handleRequest(final Map<String, Object> request, final Context context) {
    final Map<String, Object> requestContext = (Map<String, Object>) request.get("requestContext");
    final Map<String, Object> identity = (Map<String, Object>) requestContext.get("identity");
    final String userId = (String) identity.get("cognitoIdentityId");

    // etc
}