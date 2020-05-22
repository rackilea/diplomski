public Change createChange(IProgressMonitor pm)
  throws CoreException,
         OperationCanceledException
{
  ICompilationUnit unit = element.getCompilationUnit();
  TextChange change = getTextChange(unit);

  // Failed to find existing change to add our changes to
  if (change == null)
    return null;

  // Find the AST version of the method being changed
  CompilationUnit astCompUnit = parse(unit, pm);
  ASTNode astElement = NodeFinder.perform(astCompUnit, element.getNameRange());
  MethodDeclaration astMethod = (MethodDeclaration)getParent(astElement, MethodDeclaration.class);

  // Visit the contents of the method to find changes to make
  String newName = getArguments().getNewName();
  List<TraceFnFixOperation> ops = new ArrayList<TraceFnFixOperation>(1);
  TraceFnCtorFinder finder = new TraceFnCtorFinder(newName, ops);
  astMethod.accept(finder);

  // Add identified edits to the overall change
  for (TraceFnFixOperation op : ops)
  {
    change.addEdit(new ReplaceEdit(op.startPosition,
                                   op.length,
                                   "\"" + op.methodName + "\""));
  }

  // Don't return a dedicated change
  return null;
}