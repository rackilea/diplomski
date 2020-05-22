public String join(String[] arr, String d) {
    String result = arr[0];
    int i = 1;
    while (i < arr.length) {
        result += d + arr[i];
        i++;
    }
    return result;
}