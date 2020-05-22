this.referenceService
    .get(id)
    .map(this::eTag)
    .map(this::getBuilderOrDefault)
    .orElse(Response.status(Status.NOT_FOUND))
    .buld();