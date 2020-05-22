class TV extends SimpleTypeVisitor8<Void, VariableElement> {

    @Override
    public Void visitDeclared(DeclaredType type, VariableElement field) {
        System.out.println(field.getSimpleName());
        System.out.println("  type = " + type.toString());
        System.out.println("  modifiers = " + field.getModifiers());
        Element e = type.asElement();
        System.out.println("    kind = " + e.getKind());
        System.out.println("    modifiers = " + e.getModifiers());
        return null;
    }
}