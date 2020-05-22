public class Node {
  private String name;
  private ArrayList<Node> children = new ArrayList<Node>();

  public static Node parseTree(String s) throws IOException {
    StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
    tokenizer.nextToken();                 // Move to first token
    Node result = new Node(tokenizer);     // Parse root node (and children)
    if (tokenizer.ttype != StreamTokenizer.TT_EOF) {
      throw new RuntimeException("Leftover token: "+ tokenizer.ttype);
    }
    return result;
  }

  Node(StreamTokenizer tokenizer) throws IOException {
    if (tokenizer.ttype != StreamTokenizer.TT_WORD) {
      throw new RuntimeException("identifier expected; got: " + tokenizer.ttype);
    }
    name = tokenizer.sval;                  // read then name 
    if (tokenizer.nextToken() == '(') {     // Consume the name and check for Children
      tokenizer.nextToken();                // Yes, consume '('
      do {
        children.add(new Node(tokenizer));  // Add and parse a child
      } while (tokenizer.ttype != ')');     // Until we reach ')'
      tokenizer.nextToken();                // Consume ')'
    }
  }
}