Class<?> generated = generateClassWithStaticMethod();
MethodHandles.Lookup lookup = MethodHandles.lookup();
lookup = MethodHandles.privateLookupIn(generated, lookup);// Java 9
MethodHandle mh = lookup.findStatic(generated, "apply", MethodType.methodType(Object.class, String.class));
Fnct f =  (Fnct) LambdaMetafactory.metafactory(lookup, "apply", MethodType.methodType(Fnct.class),
        mh.type(), mh, mh.type()).getTarget().invokeExact();
Object result = f.apply("test");
System.out.println("result: "+result);