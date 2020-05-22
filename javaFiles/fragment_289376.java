public Response sayHello(@Context HttpServletRequest request)
        throws InterruptedException {
  Continuation c = ContinuationSupport.getContinuation(request);

  c.setTimeout(2000);
  c.suspend();

  // Do work
  System.out.println("halp");

  // End condition
  if (c.isInitial() != true) {
    c.complete();
    return Response.ok().build();
  }

  return Response.serverError().build();
}