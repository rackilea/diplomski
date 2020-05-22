4 assign statements:
 Node<T> temp = head;
 Node<T> current = head.next;
 head.next = null;
 head.previous = current;
n + 1 compare statements:
 while(current != null)
(lets not count the braces))
n * 5 assign operations:
 Node<T> next = current.next;
 current.next = temp;
 current.previous= next;
 temp = current;
 current = next;
and 1 last assign operation
 head = tail;