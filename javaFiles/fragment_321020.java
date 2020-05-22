temp = current; // i.e. temp = C as current = C
current = current.next(); // say current = B now and temp = C
current.setNext(temp); // here B's next is set to C
                       // but you forgot A's next is C in the example, now since B 
                       // is taking it's place so A's next must point to B
                       // B's next must point to C and C's next must point to D.