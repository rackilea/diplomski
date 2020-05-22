Node currentNode = n1; // start at your first node
while(currentNode != null) {
    // do logic, for now lets print the value of the node
    System.out.println(currentNode.getData());
    // proceed to get the next node in the chain and continue on our loop
    currentNode = currentNode.getNext();
}