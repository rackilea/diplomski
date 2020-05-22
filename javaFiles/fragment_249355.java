public MethodVisitor visitMethod(int access, String name, String desc,
        String signature, String[] exceptions) {

    MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
    return new RemappingMethodAdapter(access, desc, mv,
                new SimpleRemapper(cn.name, cname));
}