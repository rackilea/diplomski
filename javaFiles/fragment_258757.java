for (k = 0; k < array2.length; k++) {
    for (m = 0; m < array2[k].length; m++) {
        if (array2[k][m] == max) {
            countIndexHorizontal = k;
            countIndexVertical = m;
            // additional operation defined in 3.
        }

        // in ccp-beginner example of
        //  2, 2
        //  1, 1
        // if k=0 and m=0, you'll update the value
        // of the first row and first column giving:
        //  0, 0
        //  0, 1
        // but when k=0, m=1, you'll find 0 instead 
        // of 2 so your program will consider that
        // this row / column does not contain the 
        // highest value
    }
}