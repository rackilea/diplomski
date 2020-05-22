MethodType methodType = MethodType.methodType(Integer.class, String.class);
MethodHandles.Lookup lookup = MethodHandles.lookup();
MethodHandle handle = lookup.findConstructor(
        Integer.class, MethodType.methodType(void.class, String.class));
Function<String,Integer> f=(Function<String,Integer>)
  LambdaMetafactory.metafactory(lookup, "apply",
    MethodType.methodType(Function.class), methodType.generic(),
    handle, methodType).getTarget().invokeExact();