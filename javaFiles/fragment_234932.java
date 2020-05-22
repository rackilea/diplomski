... lots of code ...
{
mv = cw.visitMethod(ACC_PUBLIC, "mutate", "()V", null, null);
mv.visitCode();
Label l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(11, l0);
mv.visitVarInsn(ALOAD, 0);
mv.visitTypeInsn(NEW, "java/lang/Object");
mv.visitInsn(DUP);
mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
mv.visitFieldInsn(PUTFIELD, "Box", "o", "Ljava/lang/Object;");
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitLineNumber(12, l1);
mv.visitInsn(RETURN);
Label l2 = new Label();
mv.visitLabel(l2);
mv.visitLocalVariable("this", "LBox;", null, l0, l2, 0);
mv.visitMaxs(3, 1);
mv.visitEnd();
}
... more code ...