public static void main(String[] args) {
    //n = 4, r = 2, k = 3
    int[] ret1 = getKthPermutation(4, 2, 3);
    //ret1 is [1,0,0,1]

    //n = 3, r = 2, k = 1
    int[] ret2 = getKthPermutation(3, 2, 1);
    //ret2 is [1,0,1]
}

static int[] getKthPermutation(int n, int r, int k) {
    int[] array = new int[n];
    setLastN(array, r, 1);

    int lastIndex = n - 1;
    for(int count = 0; count < k; count++) {

        int indexOfLastOne = findIndexOfLast(array, lastIndex, 1);
        int indexOfLastZero = findIndexOfLast(array, indexOfLastOne, 0);
        array[indexOfLastOne] = 0;
        array[indexOfLastZero] = 1;

        //shortcut: swap the part after indexOfLastZero to keep them sorted
        int h = indexOfLastZero + 1;
        int e = lastIndex;
        while(h < e) {
            int temp = array[h];
            array[h] = array[e];
            array[e] = temp;
            h++;
            e--;
        }

    }

    return array;
}

//starting from `from`, and traveling the array forward, find the first `value` and return its index.
static int findIndexOfLast(int[] array, int from, int value) {
    for(int i = from; i > -1; i--)
        if(array[i] == value) return i;
    return -1;
}

//set the last n elements of an array to `value`
static void setLastN(int[] array, int n, int value){
    for(int i = 0, l = array.length - 1; i < n; i++)
        array[l - i] = value;
}