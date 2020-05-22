@Rule
public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

@Test
public void test() {
    // This can be a mock, but is easier here as a fake implementation
    BlahServiceImplBase serviceImpl = new BlahServiceImplBase() {
        @Override public void blah(Request req, StreamObserver<Response> resp) {
            resp.onError(new StatusRuntimeException(Status.UNAVAILABLE));
        }
    };
    // Note that the channel and server can be created in any order
    grpcCleanup.register(InProcessServerBuilder.forName("mytest")
        .directExecutor().addService(serviceImpl).build().start());
    ManagedChannel chan = grpcCleanup.register(
        InProcessChannelBuilder.forName("mytest").directExecutor().build();
    BlahServiceBlockingStub blahServiceBlockingStub
        = BlahServiceGrpc.newBlockingStub();

    blahServiceBlockingStub.blah(null);
}