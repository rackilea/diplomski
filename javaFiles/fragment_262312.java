public static String nullAwareConcat(String x, String y) {
    return x == null && y == null ? ""
        : x == null ? y
        : y == null ? x
        : x + y;
}

...

for (int i = 0; i< inputArr.length; i++){
    inputArr[i] = nullAwareConcat(inputArr[i], "ABC");
}