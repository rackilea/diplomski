public static void main(String[] args) throws Throwable {
    String staticMethodName = "apply";
    MethodType staticMethodType = MethodType.methodType(Object.class, String.class);
    Class<?> generated = generateClassWithStaticMethod("TestClass", Object.class,
        staticMethodName, staticMethodType, Fnct.class, "apply", staticMethodType);
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    System.out.println("generated "+generated);
    MethodHandle mh = lookup.findStatic(generated, "apply", MethodType.methodType(Fnct.class));
    Fnct f =  (Fnct)mh.invokeExact();
    Object result = f.apply("test");
    System.out.println("result: "+result);
}

public static Class<?> generateClassWithStaticMethod(String clName, Class<?> superClass,
    String methodName, MethodType methodType, Class<?> funcInterface, String funcName, MethodType funcType) {

    Class<?> boxedInt = Integer.class;
    ClassWriter classWriter = new ClassWriter(0);
    classWriter.visit(V1_8, ACC_PUBLIC|ACC_SUPER, clName, null, getInternalName(superClass), null);
    MethodVisitor mv = classWriter.visitMethod(
         ACC_PUBLIC|ACC_STATIC, methodName, methodType.toMethodDescriptorString(), null, null);
    mv.visitInsn(ICONST_3);
    mv.visitMethodInsn(INVOKESTATIC, getInternalName(boxedInt), "valueOf",
        MethodType.methodType(boxedInt, int.class).toMethodDescriptorString(), false);
    mv.visitInsn(ARETURN);
    mv.visitMaxs(1, 1);
    mv.visitEnd();
    String noArgReturnsFunc = MethodType.methodType(funcInterface).toMethodDescriptorString();
    mv = classWriter.visitMethod(ACC_PUBLIC|ACC_STATIC, methodName, noArgReturnsFunc, null, null);
    Type funcTypeASM = Type.getMethodType(funcType.toMethodDescriptorString());
    mv.visitInvokeDynamicInsn(funcName, noArgReturnsFunc, new Handle(H_INVOKESTATIC,
        getInternalName(LambdaMetafactory.class), "metafactory", MethodType.methodType(CallSite.class,
            MethodHandles.Lookup.class, String.class, MethodType.class, MethodType.class,
            MethodHandle.class, MethodType.class).toMethodDescriptorString()), funcTypeASM,
            new Handle(H_INVOKESTATIC, clName, methodName, methodType.toMethodDescriptorString()),
            funcTypeASM
        );
    mv.visitInsn(ARETURN);
    mv.visitMaxs(1, 0);
    mv.visitEnd();
    return new MyClassLoader().defineClass(classWriter.toByteArray());
}