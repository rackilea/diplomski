// maker is a TreeMaker instance
// sym is a Symbol.MethodSymbol instance
// body is a JCTree.JCBlock instance
JCTree.JCMethodDecl decl = maker.MethodDef(sym, body);
decl.params.forEach(p -> {
    p.sym.adr = 0;
});