public class SayHello implements Helloz {

    @Override
    public PostHellozResponse postHelloz(@QueryParam("access_token") String accessToken, HelloSchema entity) throws Exception {
        System.out.println("Hello World!");
        return PostHellozResponse.withJsonOK(null);
    }
}