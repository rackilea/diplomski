public static int[][] splitArrayByNum(int[] input, int number) {
    if(input.length == 0) {
        return new int[0][];
    }

    int count = 0;
    for (int i = 0; i < input.length; i++) {
        if (input[i] == number) {
            count++;
        }
    }

    if(input[input.length - 1] != number) {
        /*we need to add the end of the array manually*/
        count ++;
    }

    int[][] result = new int[count][];
    int firstIndex = 0;

    int iter = 0;
    for (int j = 0; j < input.length; j++) {
        if (input[j] == number) {
            result[iter++] = Arrays.copyOfRange(input, firstIndex, j);
            firstIndex = j+1;
        }
    }
    if(input[input.length - 1] != number) {
        /*manually adding the end of the array*/
        result[count-1] = Arrays.copyOfRange(input, firstIndex, input.length);
    }

    return result;
}