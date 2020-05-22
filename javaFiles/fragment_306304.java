public class Person {

private Person[] myChildren;

public int getNumberOfDescendants() {
  if (myChildren == null || myChildren.length==0) return 0;
  int myDescendants = 0;
  for (Person child:myChildren) {
    myDescendants += 1; // for this particular child itself
    myDescendants += child.getNumberOfDescendants();  //add the child's children, grandchildren, etc.
  }
  return myDescendants;
}

}