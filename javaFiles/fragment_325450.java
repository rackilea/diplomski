ListNode current = head;
// You assign head.next to prev here
// which is equal to null for the first iteration
current.next = prev;
prev = head; 
// And here you go to head.next, which was set to null above
head = head.next;
// The head is null, so the while loop ends