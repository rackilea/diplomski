public void reverse(){
    List<Node> nodes = new ArrayList<>();
    for (Node n = head; n != null; n = n.next)
        nodes.add(n);
    for (int i = nodes.size() - 1; i >= 0; i--)
        System.out.print(nodes.get(i).data + " ");
}