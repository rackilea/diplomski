public Object[] getChildren(ASTNode node) {
    List list= node.structuralPropertiesForType();
    for (int i= 0; i < list.size(); i++) {
        StructuralPropertyDescriptor curr= (StructuralPropertyDescriptor) list.get(i);
            Object child= node.getStructuralProperty(curr);
        if (child instanceof List) {
                return ((List) child).toArray();
        } else if (child instanceof ASTNode) {
            return new Object[] { child };
            }
        return new Object[0];
    }
}