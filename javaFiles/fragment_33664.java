@GET
@ExceptionMetered
@Path("/path")
@Produces(MediaType.TEXT_HTML)
public Response demoSetCookie()
{
    Cookie cookie = new Cookie("testNameCookie", "testValueCookie");
    NewCookie cookies = new NewCookie(cookie);
    return Response.status(Status.OK).type(MediaType.TEXT_HTML).entity(view).cookie(cookies)
                    .build();
}