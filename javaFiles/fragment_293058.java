public static byte[] getTransformed(byte[] originalCode) {
    ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
    ClassReader cr = new ClassReader(originalCode);
    ClassVisitor tcv = new TransformClassVisitor(cw);
    cr.accept(tcv, ClassReader.SKIP_FRAMES);
    return cw.toByteArray();
}