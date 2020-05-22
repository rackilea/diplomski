Class<?> generated = generateClassWithStaticMethod();
MethodHandles.Lookup lookup = MethodHandles.lookup().in(generated);
Field modes = MethodHandles.Lookup.class.getDeclaredField("allowedModes");
modes.setAccessible(true);
modes.set(lookup, -1);
MethodHandle mh = lookup.findStatic(generated, "apply", MethodType.methodType(Object.class, String.class));
Fnct f =  (Fnct) LambdaMetafactory.metafactory(lookup, "apply", MethodType.methodType(Fnct.class),
        mh.type(), mh, mh.type()).getTarget().invokeExact();
Object result = f.apply("test");
System.out.println("result: "+result);