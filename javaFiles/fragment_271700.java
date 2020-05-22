// request filter
filter(ContainerRequestContext request) {
  request.setProperty("key", value);
}

// response filter
filter(ContainerRequestContext request, ContainerResponseContext response) {
    Object value = request.getProperty("key");
}