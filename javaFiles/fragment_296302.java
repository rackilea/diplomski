private static byte[] disableMethod(Method method) {
    Class<?> theClass = method.getDeclaringClass();
    ClassReader cr;
    try { // use resource lookup to get the class bytes
        cr = new ClassReader(
            theClass.getResourceAsStream(theClass.getSimpleName()+".class"));
    } catch(IOException ex) {
        throw new IllegalStateException(ex);
    }
    // passing the ClassReader to the writer allows internal optimizations
    ClassWriter cw = new ClassWriter(cr, 0);
    cr.accept(new MethodReplacer(
            cw, method.getName(), Type.getMethodDescriptor(method)), 0);

    byte[] newCode = cw.toByteArray();
    return newCode;
}

static class MethodReplacer extends ClassVisitor {
    private final String hotMethodName, hotMethodDesc;

    MethodReplacer(ClassWriter cw, String name, String methodDescriptor) {
        super(Opcodes.ASM5, cw);
        hotMethodName = name;
        hotMethodDesc = methodDescriptor;
    }

    // invoked for every method
    @Override
    public MethodVisitor visitMethod(
        int access, String name, String desc, String signature, String[] exceptions) {

        if(!name.equals(hotMethodName) || !desc.equals(hotMethodDesc))
            // reproduce the methods we're not interested in, unchanged
            return super.visitMethod(access, name, desc, signature, exceptions);

        // alter the behavior for the specific method
        return new ReplaceWithEmptyBody(
            super.visitMethod(access, name, desc, signature, exceptions),
            (Type.getArgumentsAndReturnSizes(desc)>>2)-1);
    }
}
static class ReplaceWithEmptyBody extends MethodVisitor {
    private final MethodVisitor targetWriter;
    private final int newMaxLocals;

    ReplaceWithEmptyBody(MethodVisitor writer, int newMaxL) {
        // now, we're not passing the writer to the superclass for our radical changes
        super(Opcodes.ASM5);
        targetWriter = writer;
        newMaxLocals = newMaxL;
    }

    // we're only override the minimum to create a code attribute with a sole RETURN

    @Override
    public void visitMaxs(int maxStack, int maxLocals) {
        targetWriter.visitMaxs(0, newMaxLocals);
    }

    @Override
    public void visitCode() {
        targetWriter.visitCode();
        targetWriter.visitInsn(Opcodes.RETURN);// our new code
    }

    @Override
    public void visitEnd() {
        targetWriter.visitEnd();
    }

    // the remaining methods just reproduce meta information,
    // annotations & parameter names

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return targetWriter.visitAnnotation(desc, visible);
    }

    @Override
    public void visitParameter(String name, int access) {
        targetWriter.visitParameter(name, access);
    }
}