public static void sequenceCount(String s) {
    char[] arr = s.toCharArray();
    int i = 0, n = arr.length;

    while (i < n) {
        char c = arr[i];
        int count = 0;
        do {
            ++i; ++count;
        } while (i < n && arr[i] == c);
        System.out.println("letter "+ c +":"+"number of times " + count);
    }
}