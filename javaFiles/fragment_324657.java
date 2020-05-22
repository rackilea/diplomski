public static void longestBackward(int[] arr) {

    int subSeqLength = 1;
    int longest = 1;
    int indexStart = 0;
    int indexEnd = 0;

    /**
     * We iterate while we are higher then 0 not 1 as we retrieve i - 1
     */
    for (int i = arr.length - 1; i > 0; i--) {
        if (arr[i] > arr[i - 1]) {//I've changed < to > remember we are backward. 
            subSeqLength++;

            /*
             * I've removed the longestSub which is useless
            */
            if (subSeqLength > longest) {
                longest = subSeqLength;
                indexStart = i + (subSeqLength - 1); //notice that I modified the bounds
                indexEnd = i - 1;
            }
        } // Else re-initiate the length
        else {
            subSeqLength = 1;
        }
    }

    // Print the sequence
    for (int i = indexStart - 1; i > indexEnd; i--) {
        System.out.print(arr[i] + ", ");
    }
}