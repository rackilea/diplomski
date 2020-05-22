private static int[] mergeSort(int[] a){
    int[] b = new int[a.length];
    int[] tmp = new int[a.length];
    System.arraycopy(a, 0, b, 0, a.length);
    mergeSort(b, 0, b.length, tmp);
    return b;
}

public static void main(String[] args) {
    int[] a = {45, 24, 53, 13, 54, 45, 63, 23};
    int[] res = mergeSort(a);
    for (int i = 0; i < res.length; i++) {
        System.out.print(res[i] + ",");
    }
}