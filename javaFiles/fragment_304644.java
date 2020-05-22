public static void main(String[] args)throws IOException {

    Scanner s = new Scanner(System.in);

    int[] numbers = fileToArray();
    Arrays.sort(numbers);
    while(true) {
        System.out.print("Enter a number in the file: ");
        int numb = s.nextInt();

        int i = Arrays.binarySearch(numbers, numb);

        if (i < 0) {
            System.out.print("Number is not in file\n");
        } else if (i >= 0) {
            System.out.print("This number is in the file\n");

        }
    }
}