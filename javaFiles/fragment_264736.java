public class MyApplication extends Application
{
    public Authenticator authenticator;

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/", TraceResource.class);
        router.attach("/pathOne/{someId}", ResourceOne.class);
        router.attach("/pathTwo/{someId}", ResourceTwo.class);
        authenticator.setNext(router);

        Router authenticationRouter = new Router(getContext());
        authenticationRouter.attach("/{apiVersion}/{tenantId}",
            authenticator).setMatchingMode(Template.MODE_STARTS_WITH);

        return authenticationRouter;
    }
}