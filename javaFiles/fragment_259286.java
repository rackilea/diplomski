public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("AdjList [").append(N).append("] = {");
  Node n = this.first;
  for (int i = 0; i < N; i++) {
    if (i != 0) {
      sb.append(", ");
    }
    sb.append(n.toString());
    n = n.next;
  }
  sb.append("}");
  return sb.toString();
}