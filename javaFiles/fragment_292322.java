@POST
@Path("{albumcode}")
@RolesAllowed("user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadPicture(@PathParam("code") String code,
FormDataMultiPart multipart, 
@Context ContainerRequestContext requestCtx) {