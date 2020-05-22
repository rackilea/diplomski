@Override
public void visit(final int version, final int access, final String classname, final String signature, final String superName, final String[] interfaces) {
    Set<String> newinterfaces = new HashSet<String>(Arrays.asList(interfaces));
    newinterfaces.add(helloSO.class.getName().replace('.', '/'));
    super.visit(version, access, classname, signature, superName, newinterfaces.toArray(new String[newinterfaces.size()]));
}