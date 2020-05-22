removeAfter(elem):
    if head == null -> error // empty list

    current = head
    while current != null && current != elem:
        current = current.next
    ;

    if current == null -> error // elem not found
    if current.next == null -> error // no more item after elem

    content = curent.next.content
    current.next = current.next.next
    return content
;