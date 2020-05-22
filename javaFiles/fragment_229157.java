public static char[] foo(char[] arr) {
    String key = "KEY";
    char[] copy = new char[arr.length];
    for(int i = 0, index = 0; i < arr.length; i++) {
        if(arr[i] != ' ') {
            copy[i] = key.charAt(index++ % key.length());
        } else {
            copy[i] = ' ';
        }
    }
    return copy;
}