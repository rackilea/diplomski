public static void main(String[] args) throws IOException {

    try (BufferedReader brTest = new BufferedReader(new FileReader("s.txt"))) {
        String[] arr = fromTextToArray(brTest.readLine());// line 1
        brTest.readLine(); // skip line 2
        String[] arr2 = fromTextToArray(brTest.readLine());// line 3
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}

public static String[] fromTextToArray(String text) throws IOException {

    String[] arr = text.split(",");
    return arr;
}