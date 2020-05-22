public static void main(String[] args) {
    String str = "aaa,,bbb,,ccc,";
    String[] strArray = str.split(",", -1);
    for (int i = 0; i < strArray.length; i++) {
        if (strArray[i].isEmpty()) {
            strArray[i] = null;
        }
    }
    System.out.println(Arrays.toString(strArray));
}