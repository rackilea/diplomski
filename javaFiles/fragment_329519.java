public void printSubtree( int indent, node ) {
  for( int i = 0; i < indent; ++i) {
    System.out.print(" ");
  }

  if( inner node) {
    System.out.println("(" + value);     
    printSubtree(indent + elem width, left child); //this is a recursive call, alternatively use the indent formula above if you don't use recursion
    printSubtree(indent + elem width, right child);

    //we have a new line so print the indent again
    for( int i = 0; i < indent; ++i) {
      System.out.print(" ");
    }
    System.out.println(")"); 
  } else if( not empty) {
    System.out.println(value);
  } else { //empty/non existing node
    System.out.println("()");
  }
}