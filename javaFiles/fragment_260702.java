public void add(int data) {
    ...
    first= x; 
    ...
    last = x;
    ...
} 

// after:
   [1] <- first, last           // first and last now pointing to the same `node:x`.  
    |
   [/] <- first.next, last.next // first.next, last.next pointing to null.