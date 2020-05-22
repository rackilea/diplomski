public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int array[] = new int[10];

    for (int i = 0; i < 10; i++) {
        int val = scan.nextInt();
        array = insertToArray(val, array, i);   //"please insert val at place i in array"
    }
    array = plus(array);

    System.out.println(Arrays.toString(array));
}

public static int[] insertToArray(int getNum, int arr[], int place) {
    arr[place] = getNum;
    return arr;
}

public static int[] plus(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] += 10000;
    }
    return arr;
}