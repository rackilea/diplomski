// LinkedList 10->20->30
head = new Node(30);
head = insert(head, 20);
head = insert(head, 10);

// Add the new 4 head: 4->10->20->30
head = insert(head, 4);
// Traversing
traversingLinkedList(head);