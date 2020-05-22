public int solution(IntList head, int k) {
  IntList temp = head;
  int count = 0;
  while(count!=k) {
    if(temp==null) {
      return -1;
    }
    temp = temp.next;
  }

  while(temp!=null) {
    head = head.next;
    temp = temp.next;
  }
  return head.value;
}