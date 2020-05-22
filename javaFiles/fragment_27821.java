public static void main(String[] args) {
    String str = "Hello";
    char[] newStr = str.toCharArray();
    char previous = '\u0000';
    isInOrder(previous,newStr); 

}

private static boolean isInOrder(char previous, char[] arr) {
    for (char current : arr) {
        if (current < previous)
            return false;
        previous = current;
    }
    return true;
}