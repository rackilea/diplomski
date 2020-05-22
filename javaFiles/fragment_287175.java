public class SayHello implements Helloz {

    @Override
    public PostHellozResponse postHelloz(String accessToken, HelloSchema entity) throws Exception {
        System.out.println("Hello World!");
        return PostHellozResponse.withJsonOK(null);
    }
}