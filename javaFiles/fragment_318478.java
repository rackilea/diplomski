while (theNode != null) { // <-- null test.
  if (theNode.getItem().getName().equals(searchName)){ // <-- B
    occurrences++;
  } else { //theNode.getItem().getName() != searchName
    break;
  }
  theNode = theNode.getNext();
}
if (occurrences == 0) { // <-- A
  System.out.println("Flower not found!");
  return;
}