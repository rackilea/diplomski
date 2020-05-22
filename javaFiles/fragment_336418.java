public int[] makeArray(int size, int minNum, int maxNum) {
    int [] arr = new int[size];
    Random r = new Random();       

    for (int i = 0; i < size; i++) {
        arr[i] = minNum + r.nextInt(maxNum);
    }

    Arrays.sort(arr);

    return arr;
}