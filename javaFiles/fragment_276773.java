@Override
public MethodVisitor visitMethod(int access, String name,
        String desc, String signature, String[] exceptions) {



    try {
        final LinkedList<String> parameters;
        final boolean isStaticMethod;

        Type[] args = Type.getArgumentTypes(desc);
        Type ret = Type.getReturnType(desc);

        parameters = new LinkedList<String>();            
        isStaticMethod = Modifier.isStatic(access);

        return new MethodVisitor(Opcodes.ASM5) {
            // assume static method until we get a first parameter name
            public void visitLocalVariable(String name, String description, String signature, Label start, Label end, int index) {
                if (isStaticMethod && parameters.size() < args.length) {
                    parameters.add(args[index].getClassName()+" " +name);
                } else if (index > 0 && parameters.size() < args.length) {
                    // for non-static the 0th arg is "this" so we need to offset by -1
                    parameters.add(args[index-1].getClassName() +" " +name);
                }
            }

            @Override
            public void visitEnd() {
                 System.out.println("Method: "+ret.getClassName()+" "+name+"("+String.join(", ", parameters)+")");
                super.visitEnd();
            }
        };
    } catch (Exception e) {
        throw e;
    }