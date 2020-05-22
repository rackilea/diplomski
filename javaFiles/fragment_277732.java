public String describeMethod(MethodNode methodNode) {
    StringBuilder methodDescription = new StringBuilder();

    Type returnType = Type.getReturnType(methodNode.desc);
    Type[] argumentTypes = Type.getArgumentTypes(methodNode.desc);

    @SuppressWarnings("unchecked")
    List<String> thrownInternalClassNames = methodNode.exceptions;

    if ((methodNode.access & Opcodes.ACC_PUBLIC) != 0) {
        methodDescription.append("public ");
    }

    if ((methodNode.access & Opcodes.ACC_PRIVATE) != 0) {
        methodDescription.append("private ");
    }

    if ((methodNode.access & Opcodes.ACC_PROTECTED) != 0) {
        methodDescription.append("protected ");
    }

    if ((methodNode.access & Opcodes.ACC_STATIC) != 0) {
        methodDescription.append("static ");
    }

    if ((methodNode.access & Opcodes.ACC_ABSTRACT) != 0) {
        methodDescription.append("abstract ");
    }

    if ((methodNode.access & Opcodes.ACC_SYNCHRONIZED) != 0) {
        methodDescription.append("synchronized ");
    }

    methodDescription.append(returnType.getClassName());
    methodDescription.append(" ");
    methodDescription.append(methodNode.name);

    methodDescription.append("(");
    for (int i = 0; i < argumentTypes.length; i++) {
        Type argumentType = argumentTypes[i];
        if (i > 0) {
            methodDescription.append(", ");
        }
        methodDescription.append(argumentType.getClassName());
    }
    methodDescription.append(")");

    if (!thrownInternalClassNames.isEmpty()) {
        methodDescription.append(" throws ");
        int i = 0;
        for (String thrownInternalClassName : thrownInternalClassNames) {
            if (i > 0) {
                methodDescription.append(", ");
            }
            methodDescription.append(Type.getObjectType(thrownInternalClassName).getClassName());
            i++;
        }
    }

    return methodDescription.toString();
}