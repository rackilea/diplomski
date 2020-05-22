Server s = ServerBuilder.forPort(...)
    .addService(ServerInterceptors.intercept(myService, myValidator))
    ...

private final class MyValidator implements ServerInterceptor {
  ServerCall.Listener interceptCall(call, headers, next) {
    ServerCall.Listener listener = next.startCall(call, headers);
    if (call.getMethodDescriptor().getFullMethodName().equals("service/method")) {
      listener = new SimpleForwardingServerCallListener(listener) {
        @Override
        void onMessage(request) {
          validate(request);
        }
      }
    }
    return listener;
  }
}