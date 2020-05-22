public static void main(String[] args) throws Throwable {
    byte[] code = generateClassWithStaticMethod();
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    Class<?> generated = lookup.defineClass(code);// Java 9
    System.out.println("generated "+generated);
    MethodHandle mh = lookup.findStatic(generated, "apply", MethodType.methodType(Object.class, String.class));
    Fnct f =  (Fnct) LambdaMetafactory.metafactory(lookup, "apply", MethodType.methodType(Fnct.class),
            mh.type(), mh, mh.type()).getTarget().invokeExact();
    Object result = f.apply("test");
    System.out.println("result: "+result);
}

public static byte[] generateClassWithStaticMethod() {
    ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
    classWriter.visit(V1_8, ACC_PUBLIC + ACC_SUPER, "MyTestClass", null, "java/lang/Object", null);
    MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "apply", "(Ljava/lang/String;)Ljava/lang/Object;",null, null);
    mv.visitInsn(ICONST_3);
    mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
    mv.visitInsn(ARETURN);
    mv.visitMaxs(0, 0);
    mv.visitEnd();
    byte[] byteArray = classWriter.toByteArray();
    return byteArray;
}