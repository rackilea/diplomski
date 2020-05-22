public Node recAdd(String event, Node tNode) {
    //tNode -> tree node         
    if (tNode == null) {
      // Addition place found
      root = new Node(event);     // Problem is RIGHT HERE
      System.out.println("added root");
    }
  //...
}