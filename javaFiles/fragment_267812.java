@GET
public Response showHeader(@HeaderParam("reason") String reason) 
    throws UnsupportedEncodingException {
    // Decode it
    reason = MimeUtility.decodeText(reason);
    // Return the value of the decoded String
    return Response.status(Response.Status.OK)
        .entity(String.format("Value of reason = '%s'", reason))
        .build();
}