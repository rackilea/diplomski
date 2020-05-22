public static byte[] getTransformed(byte[] originalCode) {
    ClassReader cr = new ClassReader(originalCode);
    ClassWriter cw = new ClassWriter(cr, ClassWriter.COMPUTE_FRAMES);
    ClassVisitor tcv = new TransformClassVisitor(cw);
    cr.accept(tcv, ClassReader.SKIP_FRAMES);
    return cw.toByteArray();
}