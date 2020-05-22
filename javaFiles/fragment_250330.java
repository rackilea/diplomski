public class ByteBuddyTest {

    public static void main(String[] args) throws Exception {
        DynamicType.Loaded loaded =
            new ByteBuddy()
            .subclass(Object.class)
                .initializer( new ByteCodeAppender() {
                    @Override public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext,
                                                MethodDescription instrumentedMethod) {
                        StackManipulation.Size size = new StackManipulation.Compound(
                            TypeCreation.of(new TypeDescription.ForLoadedType(MyClass.class)),
                            Duplication.SINGLE,
                            MethodInvocation.invoke(new TypeDescription.ForLoadedType(MyClass.class).getDeclaredMethods().filter(ElementMatchers.isDefaultConstructor()).getOnly()),
                            FieldAccess.forField(implementationContext.getInstrumentedType().getDeclaredFields().filter(ElementMatchers.named("a")).getOnly()).write()
                        ).apply(methodVisitor, implementationContext);

                        return new Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
                    }
                })
            .name("org.test.lib.core.ConstructedClass")
            .modifiers(Opcodes.ACC_PUBLIC)
            .defineField("a", MyClass.class, Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC | Opcodes.ACC_FINAL)
            .make()
            .load(ByteBuddyTest.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION);

        Object obj = loaded.getLoaded().getConstructor().newInstance();
        System.out.println(obj.getClass().getField("a").get(obj));
    }

    public static class MyClass {
        public MyClass(String arg) {}

        public static MyClass createMyClass(String arg) {
            return new MyClass(arg);
        }
    }
}