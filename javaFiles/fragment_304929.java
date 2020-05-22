@Override
public void visitEnd() {
    if(!hasStaticInitialiser) visitMethod(CLINIT_ACCESS,CLINIT_NAME,CLINIT_DESC,CLINIT_SIG,CLINIT_EXCEPT);
    if(!hasStaticInitialiser) throw new IllegalStateException("ClinitReplacer not created");
    super.visitEnd();
}