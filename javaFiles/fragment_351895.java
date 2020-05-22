public static void main(String[] args) {

    int[] array = {2, 3, 5, 7, 11, 13};

    int tmp = array[0];
    for (int index = 0; index <= array.length - 2; index++) {
        array[index] = array[index + 1];
    }
    array[array.length - 1] = tmp;
    System.out.println(Arrays.toString(array));
}