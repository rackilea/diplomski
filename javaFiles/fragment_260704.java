// before:
   [1] <- first
    |
   [2] <- last      
    |
   [/] <- last.next // last.next to null.

public void add(int data) {
    ...
    last.next= x; // access previous-x and assign x to previous-x's next.
    ...
    last = x;     // update last from previous-x to current-x.
    ...
} 

// after:
   [1] <- first
    |
   [2]         
    |
   [3] <- last      // last is pointing to the new `node:x`. 
    |
   [/] <- last.next // last.next to null.