public static void main(String[] args) throws IOException  {
    char [] arr= { 'a', 'd', 'v', 'd', 'j' };
    String str = "dad";
    int pos = 0;
    for (char c: str.toCharArray()) {
        int i = locate(c, arr, pos);
        if (i >= 0) {
            char x = arr[pos];
            arr[pos] = arr[i];
            arr[i] = x;
            ++pos;
        }
    }
    System.out.println(toString(arr));
}

private static int locate(char c, char[] arr, int start) {
    for (int i = start; i < arr.length; ++i) {
        if (arr[i] == c) {
            return i;
        }
    }
    return -1;
}