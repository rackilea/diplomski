@GET
@Path("video")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response video() {
    File file = new File("C:/Data/video.mp4");
    return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
            .build();
}