public class SampleApplication extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/myresource", MyServerResource.class);

        (...)

        return router;
    }
}