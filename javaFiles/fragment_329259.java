public UserOrders getUserOrders(User user, Integer methodCallCount) {
    methodCallCount++;
    UserOrders userOrders;
    try {
        userOrders = restTemplate.postForObject(USER_ORDERS_URI, request, UserOrders.class);
    } catch (RestClientException ex) {
        APIError apiError = new ObjectMapper().readValue(response.getBody(), APIError.class);
        if (methodCallCount < MAX_METHOD_CALLS) {
            if (apiError.isType(ACCESS_TOKEN_EXPIRED)) {
                refreshVendorAccessTokenInfo(user);
                userOrders = getUserOrders(user, methodCallCount);
            }
        }
    }
    return userOrders;
}