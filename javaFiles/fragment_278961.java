private static Tree addNodeTsurgeon(Tree tree, String tag, String word) {
  TregexPattern pat = TregexPattern.compile("__=root !> __ !< " + tag);
  TsurgeonPattern surgery = Tsurgeon.parseOperation(
          "insert (" + tag + " " + word +") >1 root");
  return Tsurgeon.processPattern(pat, surgery, tree);
}