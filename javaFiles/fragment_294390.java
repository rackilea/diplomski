public Symbol getSymbol(CompilationUnitTree cut, JCStatement stmt, List<JCExpression> typeParams, Name varName, List<JCExpression> args) {
    java.util.List<Type> typeSyms = getArgTypes(typeParams, cut, stmt);
    java.util.List<Type> argsSyms = getArgTypes(args, cut, stmt);
    final Scope scope = getScope(cut, stmt);
    Symbol t = contains(scope, typeSyms, varName, argsSyms); //first lookup scope for all public identifiers
    TypeElement cl = scope.getEnclosingClass();
    while (t == null && cl != null) { //lookup hierarchy for inacessible identifiers too
        t = contains(elementUtils.getAllMembers(cl), typeSyms, varName, argsSyms);
        final TypeMirror superclass = cl.getSuperclass();
        if (superclass != null) {
            cl = (TypeElement) ((Type) superclass).asElement();
        }
    }
    return t;
}

public Symbol getSymbol(Name varName, Symbol accessor, CompilationUnitTree cut, JCStatement stmt) {
    if (varName.contentEquals("class")) {
        Symbol javaLangClassSym = getSymbol(cut, stmt, null, elementUtils.getName("java.lang.Class"), null);
        JCIdent id = tm.Ident(javaLangClassSym);
        JCExpression mName = tm.Select(id, elementUtils.getName("forName"));
        JCLiteral idLiteral = tm.Literal(accessor.toString());
        JCMethodInvocation mi = tm.Apply(List.<JCExpression>nil(), mName, List.<JCExpression>of(idLiteral));
        Symbol s = getSymbol(mi, cut, stmt);
        return s;
    }
    accessor = getTypeSymbol(accessor);
    java.util.List<Symbol> enclosedElements = getEnclosedElements(accessor, cut, stmt);
    Symbol s = contains(enclosedElements, null, varName, null);
    return s;
}