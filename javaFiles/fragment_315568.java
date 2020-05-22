@POST
@Path("login")
@ContentTypeFilterAnnotation
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public Response create(@Valid @NotNull @FormParam("username") final String username,
                       @Valid @NotNull @FormParam("password") final String password) {
    ...
}