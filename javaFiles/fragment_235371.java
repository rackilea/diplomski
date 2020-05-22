TRYAGAIN: for (;;) { // loop forever
    // some code here
    for (some looping here) {
        // some code here
        try {
            if (failure condition) {
                // handle failure here
                continue TRYAGAIN; // go back and try again
            }
        } finally {
            // code here will execute, even if 'continue' is used
        }
    }
    // more code and failure condition checks here
    break; // unconditional exit loop, since all is ok
}