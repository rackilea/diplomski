@Path("/callback")
public class AsyncCallback {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postWithAsync(@Suspended AsyncResponse asyncResponse,  
                                         SomeObject object) {

        asyncResponse.register(new CompletionCallback() {
            @Override
            public void onComplete(Throwable error) {
                if (error == null) {
                    System.out.println("Processing new Request");
                } else {
                    System.out.println("Exception in Request handling");
                }
            }
        });
        Response response = Response.ok("Success").build();
        // Carry on like nothing happened
        asyncResponse.resume(response);
    }
}