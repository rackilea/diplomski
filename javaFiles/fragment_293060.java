public static byte[] getTransformed(byte[] originalCode) {
    ClassReader cr = new ClassReader(originalCode);
    ClassWriter cw = new ClassWriter(cr, 0);
    ClassVisitor tcv = new TransformClassVisitor(cw);
    cr.accept(tcv, 0);
    return cw.toByteArray();
}