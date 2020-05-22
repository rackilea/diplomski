public static void main(String[] args) throws FileNotFoundException {
  String treeString = "(ROOT (S (NP (NNP John)) (VP (VBZ eats) (NP (NN pizza))) (. .)))";
  Tree tree = Tree.valueOf(treeString);
  SemanticGraph graph = SemanticGraphFactory.generateUncollapsedDependencies(tree);

  //add lemmata
  Morphology morphology = new Morphology();
  for (IndexedWord node : graph.vertexSet()) {
    String lemma = morphology.lemma(node.word(), node.tag());
    node.setLemma(lemma);
  }

  System.err.println(graph);
  SemgrexPattern semgrex = SemgrexPattern.compile("{}=A <<dobj=reln {lemma:/eat/}=B");
  SemgrexMatcher matcher = semgrex.matcher(graph);
  while (matcher.find()) {
    System.err.println(matcher.getNode("A") + " <<dobj " + matcher.getNode("B"));
  }
}