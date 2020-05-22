interface SpecialFunction {
    Map<String,SpecialFunction> PREDEFINED = getMap();

    String call(int i, double d, String s);

    static String method1(int i, double d, String s) {
        return "method1("+i+", "+d+", "+s+')';
    }
    static String method2(int i, double d, String s) {
        return "method2("+i+", "+d+", "+s+')';
    }
    static String method3(int i, double d, String s) {
        return "method3("+i+", "+d+", "+s+')';
    }
    /* private  (with Java 9) */ static Map<String,SpecialFunction> getMap() {
        Map<String,SpecialFunction> map = new HashMap<>();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType invoked = MethodType.methodType(SpecialFunction.class);
        MethodType func = MethodType.methodType(String.class,
                                                int.class, double.class, String.class);
        final int mod = Modifier.PUBLIC|Modifier.STATIC;
        for(Method m: SpecialFunction.class.getDeclaredMethods()) try {
            MethodHandle target = lookup.unreflect(m);
            if((m.getModifiers()&mod) == mod && target.type().equals(func))
                map.put(m.getName(), (SpecialFunction)LambdaMetafactory.metafactory(
                    lookup, "call", invoked, func, target, func).getTarget().invoke());
        } catch(Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
        return Collections.unmodifiableMap(map);
    }
}