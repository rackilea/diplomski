public String describeClass(ClassNode classNode) {
    StringBuilder classDescription = new StringBuilder();

    Type classType = Type.getObjectType(classNode.name);



    // The class signature (e.g. - "public class Foo")
    if ((classNode.access & Opcodes.ACC_PUBLIC) != 0) {
        classDescription.append("public ");
    }

    if ((classNode.access & Opcodes.ACC_PRIVATE) != 0) {
        classDescription.append("private ");
    }

    if ((classNode.access & Opcodes.ACC_PROTECTED) != 0) {
        classDescription.append("protected ");
    }

    if ((classNode.access & Opcodes.ACC_ABSTRACT) != 0) {
        classDescription.append("abstract ");
    }

    if ((classNode.access & Opcodes.ACC_INTERFACE) != 0) {
        classDescription.append("interface ");
    } else {
        classDescription.append("class ");
    }

    classDescription.append(classType.getClassName()).append("\n");
    classDescription.append("{\n");



    // The method signatures (e.g. - "public static void main(String[]) throws Exception")
    @SuppressWarnings("unchecked")
    List<MethodNode> methodNodes = classNode.methods;

    for (MethodNode methodNode : methodNodes) {
        String methodDescription = describeMethod(methodNode);
        classDescription.append("\t").append(methodDescription).append("\n");
    }



    classDescription.append("}\n");

    return classDescription.toString();
}