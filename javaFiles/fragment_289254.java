@Path("stream")
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public class ClientStreamingResource {

    private static final String INFILE = "Some File";

    @GET
    @Path("file")
    public Response fileEndpoint() {
        final File file = new File(INFILE);
        final StreamingOutput output = new StreamingOutput() {
            @Override
            public void write(OutputStream out) {

                try (FileInputStream in = new FileInputStream(file)) {
                    byte[] buf = new byte[512];
                    int len;
                    while ((len = in.read(buf)) != -1) {
                        out.write(buf, 0, len);
                        out.flush();
                        System.out.println("---- wrote 512 bytes file ----");
                    }
                } catch (IOException ex) {
                    throw new InternalServerErrorException(ex);
                }
            }
        };
        return Response.ok(output)
                .header(HttpHeaders.CONTENT_LENGTH, file.length())
                .build();
    }

    @GET
    @Path("client")
    public void clientEndpoint(@Suspended final AsyncResponse asyncResponse) {
        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("http://localhost:8080/stream/file");
        final Response clientResponse = target.request().get();

        final StreamingOutput output = new StreamingOutput() {
            @Override
            public void write(OutputStream out) {
                try (final InputStream entityStream = clientResponse.readEntity(InputStream.class)) {
                    byte[] buf = new byte[512];
                    int len;
                    while ((len = entityStream.read(buf)) != -1) {
                        out.write(buf, 0, len);
                        out.flush();
                        System.out.println("---- wrote 512 bytes client ----");
                    }
                } catch (IOException ex) {
                    throw new InternalServerErrorException(ex);
                }
            }
        };
        ResponseBuilder responseBuilder = Response.ok(output);
        if (clientResponse.getHeaderString("Content-Length") != null) {
            responseBuilder.header("Content-Length", clientResponse.getHeaderString("Content-Length"));
        }
        new Thread(() -> {
            asyncResponse.resume(responseBuilder.build());
        }).start();
    }
}