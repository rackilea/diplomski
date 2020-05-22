Node<E> temp;
temp = head;

while (temp != null && temp.value != obj) {
  temp = temp.next;
}
System.out.println(temp == null ? "NO" : "YES");