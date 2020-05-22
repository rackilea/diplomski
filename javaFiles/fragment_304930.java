@Override
public void visitEnd() {
    if(!hasStaticInitialiser) {
        MethodVisitor mv = visitMethod(CLINIT_ACCESS,CLINIT_NAME,CLINIT_DESC,CLINIT_SIG,CLINIT_EXCEPT);
        mv.visitCode();
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }
    if(!hasStaticInitialiser) throw new IllegalStateException("ClinitReplacer not created");
    super.visitEnd();
}