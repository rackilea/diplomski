try (PrintWriter out = new PrintWriter(file, "UTF-8")) {
    print(out, root);
} // automatically closes out

void print(PrintWriter out, Node node) {
    if (node != null) {
        print(out, node.left);
        out.println(...);
        print(out, node.right);
    }
}