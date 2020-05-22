public static void main(String[] args) {
    String str = "Hello My Name Is Hypherius241";
    String[] arr = str.split(" ");
    for (int i = 0; i < arr.length; i++) {
        System.out.printf("arr[%d] = \"%s\";\n", i, arr[i]);
    }
}