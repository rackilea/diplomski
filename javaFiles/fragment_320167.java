class Node {
  String message;
  Node yes;
  Node no;
}

Reader myFile = new FileReader("datafile.txt"); // reads your file
Node myTree = parseNode(); // will point to the root of your tree

// This recursive function traverses (and builds) your tree.
Node parseNode() {
  Node newNode;
  String input = myFile.readline();
  if (input.equals("#)) {
    return null;
  } else {
    newNode.message = input;
    newNode.yes = parseNode();
    newNode.no = parseNode();
}