class Node { ... }

class StringLiteral extends Node {
  public String getValue() { ... }
}

class Term extends Node {
  public String getName() { ... }
  public int getArity() { ... }
  public Node getArgument(int index) { ... }
}