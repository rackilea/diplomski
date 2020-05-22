Node<E> temp = head;
while(temp != null) {   // Don't check for next here or miss the last element
  if (temp.value == obj) {
    System.out.println("YES: " + value);
    break;
  } 
  System.out.println("NO: " + value);
  temp = temp.next;

  // Loop check (if needed)
  if (temp == head) {
    break;
  }
}