Node node = head; // top of the stack

  while(node != null){
     stream.println(node.value);
     stream.flush();
     node = node.next;
  }