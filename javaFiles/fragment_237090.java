public static String[] cleanUp(String str1, String str2) {
    String[] arr = { str1, str2 };
    for (int i = 0; i < arr.length; i++) {
        arr[i] = arr[i].replaceAll("\\p{Punct}", "");
        System.out.println("string cleaned:" + arr[i]);
    }
    return arr;
}