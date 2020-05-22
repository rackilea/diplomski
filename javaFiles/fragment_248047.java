@Override
public Restlet createInboundRoot() {
    Router router = new Router( getContext() );

    router.attachDefault( TestActionResource.class );
    router.attach( "http://localhost:8111/echo", EchoResource.class );

    return router;
}