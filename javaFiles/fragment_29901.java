MethodHandle start = identity(String.class);
MethodHandle sideEffect = lookup().findVirtual(PrintStream.class, "println", methodType(void.class, String.class)).bindTo(System.out);
MethodHandle result = collectArguments(start, 0, sideEffect); // sideEffect needs to return nothing
result = permuteArguments(result, methodType(String.class, String.class), 0, 0); // copy argument

System.out.println((String) result.invokeExact("Hello")); // Hello\nHello