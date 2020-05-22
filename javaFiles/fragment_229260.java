class InputTest {

    public static void main(String[] args) {
        System.out.print("Enter size of array: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfArray = scanner.nextInt();
        Integer[] input = new Integer[numberOfArray];

        for (int i = 0; i < numberOfArray; i++) {
            System.out.print("Input number " + (i + 1) + ": ");
            input[i] = scanner.nextInt();
        }

        Arrays.sort(input, Collections.reverseOrder());

        for (int i : input) {
            System.out.print(i + ",");
        }
    }
}