private static MethodHandle MH_NativeFunction_function() {
  try {
    return MethodHandles.lookup().findStatic(
      jdk.nashorn.internal.objects.NativeFunction.class, "function",
      MethodType.fromMethodDescriptorString("(ZLjava/lang/Object;[Ljava/lang/Object;)"
        + "Ljdk/nashorn/internal/runtime/ScriptFunction;", null));
  } catch(ReflectiveOperationException ex) {
      throw new AssertionError(ex);
  }
}