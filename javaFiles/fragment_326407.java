Node changeUtil(Node head)
{
  // Ignore if not both the 1st and 3rd node exist
  // This is were your code fails!!
  if ((head == null) || (head.next == null) || (head.next.next == null))
    return (head);

  // Point to 3rd node
  Node third;
  third = head.next.next;

  // Swap contents
  int temp;
  temp = head.data;
  head.data = third.data;
  third.data = temp;

  // Same stuff starting from 4th node
  changeUtil(third.next);

  // Done
  return (head);

} // changeUtil