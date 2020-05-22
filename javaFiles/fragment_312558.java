private void collectTo(List<String> result, CommentNode node, Matcher matcher) {
    if (node == null) return;
    String s = node.getComment().getBody();
    if (s != null && matcher.reset(s).matches()) {
         result.add(s);
    }
    for (CommentNode child : node.getChildren()) {
        collectTo(result, child, matcher);
    }
}