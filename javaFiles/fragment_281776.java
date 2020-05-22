public Step getMethodFromStepid(ProcessBase process, int stepid) {
    try {
            // standard reflection stuff
            final String mname = "step_"+stepid;
            final Method method = process.getClass().getMethod(mname);
            // new java8 method reference stuff
            final MethodType type=MethodType.methodType(Boolean.class);
            // invokedType: bind process, generate Step
            final MethodType stepType=MethodType.methodType(Step.class,process.getClass());
            final MethodHandles.Lookup caller = MethodHandles.lookup();
            final MethodHandle unreflect = caller.unreflect(method);
            final CallSite site = LambdaMetafactory.metafactory(
                caller, "apply", stepType, type, unreflect, type);
            // convert site to my method reference
            final MethodHandle factory = site.getTarget();
            // pass the value to bind and get the functional interface instance
            final Step step = (Step)factory.invoke(process);
            return step;
      } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
      }
}