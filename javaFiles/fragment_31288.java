MethodHandles.Lookup l=MethodHandles.lookup();
Consumer<RoutingContext> c=(Consumer<RoutingContext>)
  LambdaMetafactory.metafactory(l, "accept",
    MethodType.methodType(Consumer.class, getClass()),
    MethodType.methodType(void.class, Object.class), l.unreflect(method),
    MethodType.methodType(void.class, RoutingContext.class))
  .getTarget().invoke(this);