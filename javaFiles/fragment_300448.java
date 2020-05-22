public static void main(String[] args) {
    String text =
            "5\n" +
            "line 1\n" +
            "line 2\n" +
            "line 3\n" +
            "line 4\n" +
            "line 5\n" +
            "line 6\n";

    Scanner input = new Scanner(new ByteArrayInputStream(text.getBytes()));

    int n = input.nextInt();     //n is my input number
    input.nextLine();

    String[] arr = new String[n];
    for(int i = 0; i < n; i++) {
        arr[i] = input.nextLine();
    }
    System.out.println(Arrays.asList(arr)); // [line 1, line 2, line 3, line 4, line 5]
}