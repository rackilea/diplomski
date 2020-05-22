protected String printLdcInsnNode(LdcInsnNode ldc, ListIterator<?> it) {
    if (ldc.cst instanceof String)
        return nameOpcode(ldc.opcode()) + " \"" + StringEscapeUtils.escapeJava(ldc.cst.toString()) + "\" (" + ldc.cst.getClass().getCanonicalName() + ")";

   return nameOpcode(ldc.opcode()) + " " + StringEscapeUtils.escapeJava(ldc.cst.toString()) + " (" + ldc.cst.getClass().getCanonicalName() + ")";
}