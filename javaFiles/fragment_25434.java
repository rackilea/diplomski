this.referenceService
    .get(id)
    .map(this::eTag)
    .map(entityTag -> Optional.ofNullable(this.request.evaluatePreconditions(entityTag))
                                .orElseGet(() -> Response.ok()
                                                        .entity(entityTag)
                                                        .cacheControl(this.cacheControl)
                                                        .tag(entityTag)))
    .orElse(Response.status(Status.NOT_FOUND))
    .buld();