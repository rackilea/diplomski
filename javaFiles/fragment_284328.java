Object o = new Node<Integer>(10);
Node<String> node = new Node<>("Hello");
if(o instanceof Node) {
  Node other = (Node) o;
  other.value = node.value; //Uh oh! Warning
}
System.out.println(node); //Hello
System.out.println(other); //Hello - WTH!