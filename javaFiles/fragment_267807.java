public static int mode(int[] input) {

    int[] count = new int[101];

    //count the occurrences
    for (int i=0; i < input.length; i++) {
        count[input[i]]++;
    }

    //go backwards and find the count with the most occurrences
    int index = count.length-1;
    for (int i=count.length-2; i >=0; i--) {
        if (count[i] >= count[index])
            index = i;
    }

    return index;
}