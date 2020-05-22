while (theNode.getItem().getName() != searchName) { // <-- NO!
  if (theNode.getItem().getName().equals(searchName)) { // <-- B
    occurrences++;
  } else if (theNode.getNext() == null){ // <-- A
    System.out.println("Flower not found!");
    return;
  }
  theNode = theNode.getNext();
}