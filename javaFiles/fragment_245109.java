public Response sendOKResponse(request req) {
    ResponseBuilder response = Response.ok();

    // set the header params.
    for(Header h: req.headerParameters()) {
        builder = builder.header(h.getName(), h.getValue());
    }

    // set the body and response code
    builder = builder.entity(req.getBody());

    return builder.build();
}