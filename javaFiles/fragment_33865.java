public Integer pop() throws EmptyStackException {
  if (head == null) throw new EmptyStackException();
  Integer result = head.value;
  head = head.next;
  return result;
}