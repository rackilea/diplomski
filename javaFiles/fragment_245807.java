@PUT()
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
@ApiOperation(value = "Bla bla.")
@Path("secure/flappy")
@ApiImplicitParams({
    @ApiImplicitParam(name = "file", value = "bla bla.", required = true, dataType = "java.io.File", paramType = "form")
})
public Response testput(@ApiParam(hidden = true) @FormDataParam("file") final  InputStream certificate
) throws Throwable {
    //TODO do something
    return Response.ok().build();
}