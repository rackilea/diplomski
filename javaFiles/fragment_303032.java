@OPTIONS
@Path("myfunction")
public Response cors() {
    return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
        // whatever other CORS headers
        .build();
}