@Path("streaming")
public class StreamingResource {

    @GET
    @Produces("application/octet-stream")
    public Response getStream() {
        return Response.ok(new FeedReturnStreamingOutput()).build();
    }

    public static class FeedReturnStreamingOutput implements StreamingOutput {

        @Override
        public void write(OutputStream output)
                throws IOException, WebApplicationException {
            try {
                for (int i = 0; i < 10; i++) {
                    output.write(String.format("Hello %d\n", i).getBytes());
                    output.flush();
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {  throw new RuntimeException(e); }
        }
    }
}