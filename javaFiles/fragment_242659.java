class Test {
    public static double op0(double a) { ... }
    public static double op1(double a) { ... }
    public static double op2(double a) { ... }
    public static double op3(double a) { ... }
    public static double op4(double a) { ... }

    static final Map<String, DoubleUnaryOperator> OPS;
    static {
        HashMap<String, DoubleUnaryOperator> map=new HashMap<>();
        MethodType type=MethodType.methodType(double.class, double.class);
        MethodType inT=MethodType.methodType(DoubleUnaryOperator.class);
        MethodHandles.Lookup l=MethodHandles.lookup();
        for(Method m:Test.class.getDeclaredMethods()) try {
          if(!Modifier.isStatic(m.getModifiers())) continue;
          MethodHandle mh=l.unreflect(m);
          if(!mh.type().equals(type)) continue;
          map.put(m.getName(), (DoubleUnaryOperator)LambdaMetafactory.metafactory(
            l, "applyAsDouble", inT, type, mh, type).getTarget().invokeExact());
        } catch(Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
        OPS=Collections.unmodifiableMap(map);
    }
}