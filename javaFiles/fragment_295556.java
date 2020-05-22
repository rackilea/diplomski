@GET
@Produces(MediaType.TEXT_PLAIN)
@Path("/{arg}")
public Response get(@PathParam("arg") {

    //get your data based on "arg"

    StreamingOutput stream = new StreamingOutput() {
        @Override
        public void write(OutputStream os) throws IOException, WebApplicationException {
            Writer writer = new BufferedWriter(new OutputStreamWriter(os));

            for (org.neo4j.graphdb.Path path : paths) {
                writer.write(path.toString() + "\n");
            }
            writer.flush();
        }
    };

    return Response.ok(stream).build();
}

@PUT
@Consumes("application/octet-stream")
public Response putFile(@Context HttpServletRequest request,
                     @PathParam("fileId") long fileId,
                     InputStream fileInputStream) throws Throwable {
    // Do something with the fileInputStream
    // etc
}