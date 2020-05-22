CUCorrectionProposal cUCorrectionProposal = (CUCorrectionProposal) eclipseProposal;
    ICompilationUnit iCompilationUnit = cUCorrectionProposal.getCompilationUnit();

    ASTParser parser = ASTParser.newParser(AST.JLS3);
    parser.setKind(ASTParser.K_COMPILATION_UNIT);
    parser.setSource(iCompilationUnit );

    CompilationUnit compilationUnit = (CompilationUnit) parser.createAST(null);