int[] indexArray = new int[arrays.length];
mainLoop: while (true) {
    /* Compute this entry. */
    int result = 1;
    for (int i = 0; i < arrays.length; i++) {
        result *= arrays[i][indexArray[i]]
    }
    System.out.println(result);

    /* Increment the index array. */
    int index = 0;
    while (true) {
        /* See if we can bump this array index to the next value.  If so, great!
         * We're done.
         */
        indexArray[index]++;
        if (indexArray[index] < arrays[i].length) break;

        /* Otherwise, overflow has occurred.  If this is the very last array, we're
         * done.
         */
        indexArray[index] = 0;
        index ++;

        if (index == indexArray.length) break mainLoop;
    }
}