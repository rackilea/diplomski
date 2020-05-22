String className = "TestClass";
ClassWriter classWriter = new ClassWriter(0);
classWriter.visit(V1_8, ACC_PUBLIC, className, null, getInternalName(Object.class), null);
MethodVisitor mv = classWriter.visitMethod(ACC_PUBLIC | ACC_STATIC, "m", "()Z",null, null);
Label trueLabel = new Label();
Label afterFalseLabel = new Label();
mv.visitFieldInsn(GETSTATIC, getInternalName(Boolean.class),"TRUE","Ljava/lang/Boolean;");
mv.visitMethodInsn(INVOKEVIRTUAL,getInternalName(Boolean.class),"booleanValue","()Z",false);
mv.visitJumpInsn(IFEQ, trueLabel);
mv.visitInsn(ICONST_1);
mv.visitJumpInsn(GOTO, afterFalseLabel);
// target of IFEQ, the frame state is "no variables, no stack entries"
mv.visitFrame(F_NEW, 0, null, 0, null);
mv.visitLabel(trueLabel);
mv.visitInsn(ICONST_0);
// merge point of the two branches, frame state is "no variables, one INTEGER on the stack"
mv.visitFrame(F_NEW, 0, null, 1, new Object[]{ INTEGER });
mv.visitLabel(afterFalseLabel);
mv.visitInsn(IRETURN);
// no variable at all, at most one stack entry (the integer)
mv.visitMaxs(1, 0);
mv.visitEnd();