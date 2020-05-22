public static void main(String[] args) {

    // create random test data
    Random random = new Random();
    Integer[] data = new Integer[50];
    for (int i = 0; i < data.length; i++) {
        data[i] = random.nextInt(100);
    }

    // print unsorted data
    System.out.println(Arrays.asList(data));
    // uncomment the algorithm you want to test
    quickSort(data);
//  mergeSort(data, 0, data.length - 1);
//  selectionSort(data);
//  PinsertionSort(data, data.length);
//  PbubbleSort(data, data.length);
    // print sorted data
    System.out.println(Arrays.asList(data));
}