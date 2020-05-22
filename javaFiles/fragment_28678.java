while (p*p < s) {  // repeat until p^2 > size of the ORIGINAL set 
        for (int i = 0; i <= b.length(); i++) {
            if (i%p == 0) { // if it's a multiple of p
                b.set(i, false); // set it to false (not prime)
            }
        }
        p = b.nextSetBit(p);
        // Make p = first bit that is set to true starting after the previous p index.
    }