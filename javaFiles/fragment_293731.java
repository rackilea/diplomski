if(data > temp.data) {    // First, check if you need to insert at the end.
        newNode.prev = temp;
        temp.next = newNode;
    } else if(temp == head) { // Then, check if you need to insert before head.
        newNode.next = temp;
        temp.prev = newNode;
        head = newNode;
    } else {                  // Otherwise, insert somewhere in the middle.
        newNode.prev = temp.prev;
        newNode.next = temp;
        temp.prev.next = newNode;
        temp.prev = newNode;
    }