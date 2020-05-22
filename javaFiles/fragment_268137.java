byte[] bytecode = … // result of your instrumentation
ClassReader cr = new ClassReader(bytecode);
// passing cr to ClassWriter to enable optimizations
ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
        MethodVisitor writer=super.visitMethod(access, name, desc, signature, exceptions);
        return new MethodVisitor(Opcodes.ASM5, writer) {
            // not changing anything, just preventing code specific optimizations
        };
    }
}, ClassReader.SKIP_FRAMES);
bytecode = cw.toByteArray(); // with recalculated stack maps