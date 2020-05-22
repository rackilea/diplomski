// before:
   [1] <- first, last          
    |
   [/] <- first.next, last.next // first.next, last.next pointing to null.

public void add(int data) {
    ...
    // technically, since first and last pointing to the same node[1],
    // x actually being assigned to both first.next and last.next.
    last.next= x; 
    ...
    last = x;     // update last from previous-x to current-x.
    ...
} 

// after:
   [1] <- first
    |
   [2] <- last      // first.next, last is pointing to the new `node:x`.
    |
   [/] <- last.next // last.next to null.