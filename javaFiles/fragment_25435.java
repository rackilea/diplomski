private ResponseBuilder getBuilderOrDefault(EntityTag entityTag) {
    return Optional.ofNullable(this.request.evaluatePreconditions(entityTag))
                   .orElseGet(() -> Response.ok()
                                            .entity(entityTag)
                                            .cacheControl(this.cacheControl)
                                            .tag(entityTag));
}