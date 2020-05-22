add(double num) {
  //Step 1 from above
  NumNode tempNode = new NumNode(num)

  //Step 2
  tail.child = tempNode

  //Step 3
  tail = tempNode
}