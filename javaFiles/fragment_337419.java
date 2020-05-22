MethodType methodType = MethodType.methodType(Integer.class, String.class);
MethodHandles.Lookup lookup = MethodHandles.lookup();
MethodHandle handle = lookup.findStatic(Integer.class, "valueOf", methodType);
Function<String,Integer> f=(Function<String,Integer>)
  LambdaMetafactory.metafactory(lookup, "apply",
    MethodType.methodType(Function.class), methodType.generic(),
    handle, methodType).getTarget().invokeExact();

System.out.println(f.apply("123"));