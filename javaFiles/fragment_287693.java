public List<Integer> getNormalList() {
    Random r = new Random();
    int[] arr = new int[3]; // initialized to 0s by default
    int Low = 0;
    int High = 6;
    while (arr[0] == arr[1] && arr[1] == arr[2]) { // will repeat as long as the 3 number as
                                                   // all equal
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(High - Low) + Low;
        }
    }
    return Arrays.asList(arr);
}