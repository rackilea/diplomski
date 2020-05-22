public static void main(String[] args) {
    char[] arr = "WBRBBWBRRBWBR".toCharArray();
    sort(arr);
    System.out.println(String.valueOf(arr));
}
public static void sort(char[] arr) {
    int rCount = sortFirst(arr, 0, 'R');
    sortFirst(arr, rCount, 'B');
}
public static int sortFirst(char[] arr, int offset, char ch) {
    int chCount = 0;
    for (int i = offset; i < arr.length; i++) {
        if (arr[i] == ch) {
            if (i > offset + chCount)
                swap(arr, offset + chCount, i);
            chCount++;
        }
    }
    return chCount;
}
public static void swap(char[] arr, int index1, int index2) {
    char h = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = h;
}