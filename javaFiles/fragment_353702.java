@Override
public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
    if (instrument && name.equals("<init>")) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        // insert code in constructor to initialize instance field propertyChangeSupport
        ...
    } else if (instrument && isPublicSetter(access, name, desc)) {
        String propertyName = Introspector.decapitalize(name.substring(3));
        String getter = "get" + name.substring(3);
        Type type = Type.getArgumentTypes(desc)[0];
        String arg = type.getDescriptor();

        // rename method by prepending an underscore and make it private
        MethodVisitor orig = super.visitMethod(access & ~ACC_PUBLIC | ACC_PRIVATE | ACC_SYNTHETIC, "_" + name, desc, signature, exceptions);

        // create a wrapper method replacing the original one
        MethodVisitor wrap = super.visitMethod(access, name, desc, signature, exceptions);
        wrap.visitCode();

        wrap.visitVarInsn(ALOAD, 0);
        wrap.visitFieldInsn(GETFIELD, classname, "_propertyChangeSupport", "Ljava/beans/PropertyChangeSupport;");
        // Stack: _propertyChangeSupport

        wrap.visitLdcInsn(propertyName);
        // stack: _propertyChangeSupport, propertyName

        wrap.visitVarInsn(ALOAD, 0);
        // stack: _propertyChangeSupport, propertyName, this

        wrap.visitMethodInsn(INVOKEVIRTUAL, classname, getter, "()" + arg);
        generateAutoBoxIfNeccessary(wrap, arg);
        // stack: _propertyChangeSupport, propertyName, oldValue

        wrap.visitVarInsn(type.getOpcode(ILOAD), 1);
        generateAutoBoxIfNeccessary(wrap, arg);
        // stack: _propertyChangeSupport, propertyName, oldValue, newValue

        wrap.visitVarInsn(ALOAD, 0);
        wrap.visitVarInsn(type.getOpcode(ILOAD), 1);

        // stack: _propertyChangeSupport, property, oldValue, newValue, this, newValue
        // invoke original setter
        wrap.visitMethodInsn(INVOKEVIRTUAL, classname, "_" + name, desc);

        // stack: _propertyChangeSupport, property, oldValue, newValue
        wrap.visitMethodInsn(INVOKEVIRTUAL, "java/beans/PropertyChangeSupport", "firePropertyChange", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V");

        wrap.visitInsn(RETURN);
        wrap.visitMaxs(6, 2);
        wrap.visitEnd();

        return orig;
    } else {
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}