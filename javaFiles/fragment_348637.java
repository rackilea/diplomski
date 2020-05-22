public List<Tree.Kind> nodesToVisit() {
    return ImmutableList.of(Tree.Kind.CLASS);
  }

  public void visitNode(Tree tree) {
    if(!hasSemantic()) {
      return;
    }
   ... rule logic
  }