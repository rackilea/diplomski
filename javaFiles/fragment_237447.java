private static final class FieldAssignConstructor implements Implementation {
    @Override
    public InstrumentedType prepare(InstrumentedType instrumentedType) {
        return instrumentedType;
    }

    @Override
    public ByteCodeAppender appender(Target implementationTarget) {
        return new ByteCodeAppender() {

            @Override
            public Size apply(MethodVisitor methodVisitor, Context instrumentationContext,
                    MethodDescription instrumentedMethod) {

                StackManipulation.Size size = new StackManipulation.Compound(
                        MethodVariableAccess.REFERENCE
                                .loadFrom(0),
                        MethodInvocation.invoke(new TypeDescription.ForLoadedType(Example.class)
                                .getDeclaredMethods().filter(ElementMatchers.isConstructor()
                                        .and(ElementMatchers.takesArguments(0)))
                                .getOnly()),
                        MethodVariableAccess.REFERENCE.loadFrom(0), //
                        MethodVariableAccess.REFERENCE.loadFrom(1), //
                        FieldAccess
                                .forField(implementationTarget.getInstrumentedType().getDeclaredFields()
                                        .filter(ElementMatchers.named(CONFIG_CACHE)).getOnly())
                                .write(),
                        MethodReturn.VOID).apply(methodVisitor, instrumentationContext);
                return new Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
            }
        };
    }
}