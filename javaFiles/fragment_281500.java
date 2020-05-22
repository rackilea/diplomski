public static boolean isBasicType(String stack_type) {
    if (stack_type.equals("Object")) {
        return true;
    } else if (stack_type.equals("String")) {
        return true;
    } else if (stack_type.equals("Integer")) {
        return true;
    } else if (stack_type.equals("Character")) {
        return true;
    } else if (stack_type.equals("int")) {
        return true;
    } else {
        return stack_type.equals("char");
    }
}