1 > 2 > 3 > 4 > 5 > null - our list

Before the while loop: node = 1, head = null

While moving over the list:

1:                 1 > null; node = 1, head = null, node.next = head, head = node

2:             2 > 1 > null; node = 2, head = 1,    node.next = head, head = node

3:         3 > 2 > 1 > null; node = 3, head = 2,    node.next = head, head = node

4:     4 > 3 > 2 > 1 > null; node = 4, head = 3,    node.next = head, head = node

5: 5 > 4 > 3 > 2 > 1 > null; node = 5, head = 4,    node.next = head, head = node