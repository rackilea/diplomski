public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String[] data = in.nextLine().split(" ");
    int[] numbers = new int[data.length];
    for (int i = 0; i < data.length; i++) {
        numbers[i] = Integer.parseInt(data[i]);
    }
    System.out.println(Arrays.toString(numbers));
}