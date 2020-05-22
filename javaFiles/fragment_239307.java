@Override
public void visit(
        final VariableDeclarationExpr n,
        final Object arg) {
    final Type varType = n.getType();
    n.getVars().forEach(vd ->
        varNameToType.put(vd.getId().getName(),varType)
    );
}