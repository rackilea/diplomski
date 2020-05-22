private String formatNode(int node) {
    return formatAsInteger ? Integer.toString(node + 1) : Character.toString((char) (node + 'A'));
}

// ...

for (int i = 1; i < 26; i++) {
    System.out.println("From node " + formatNode(0) + " to node " + formatNode(i));
}