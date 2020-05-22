private CtMethod overrideMethod(CtClass ctClass, CtMethod getConnectionMethodOfSuperclass)
        throws NotFoundException, CannotCompileException {
    final CtMethod m = CtNewMethod.delegator(getConnectionMethodOfSuperclass, ctClass);
    ctClass.addMethod(m);
    return m;
}