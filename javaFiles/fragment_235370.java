for (;;) { // loop forever
    // some code here
    if (failure condition 1) {
        // handle failure here
        continue; // go back and try again
    }
    if (failure condition 2) {
        // handle failure here
        continue; // go back and try again
    }
    // more code and failure condition checks here
    break; // unconditional exit loop, since all is ok
}