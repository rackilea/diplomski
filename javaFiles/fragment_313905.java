Node upper = list.head; //Upper half of list pointer
Node lower = list.get(l.length/2); //Lower half of list pointer
Node temp = null; //Utility pointer to hold whatever we need

//Let's set up our initial state
list.get(l.length/2-1) = null; //Disconnect two halves of the list
temp = upper.next; //Hold upper half minus head
upper.next = lower; //First element of upper half stitched to bottom half

//Note that lower would need to be at `l.length/2+1` for an odd length list
//This also applies to list.get in the set up
//The code could be generalized to both even and odd lenghts by using `Math.ceil`
// or a similar function to round up instead of Java's default of rounding down

zigZag(upper, lower, temp); //Call to algorithm