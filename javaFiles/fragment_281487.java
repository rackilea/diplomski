parser.setKind(ASTParser.K_COMPILATION_UNIT);
    final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
    IProblem[] problems = cu.getProblems();
    for(IProblem problem : problems) {
        System.out.println("problem: " + problem.getMessage() + problem.getSourceStart());
    }