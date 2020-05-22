public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    StringBuilder output = new StringBuilder();


    System.out.println("Enter the number of rows & columns: ");

    System.out.print("Enter the number of rows: ");
    int row = input.nextInt();
    System.out.print("Enter the number of columns: ");
    int columns = input.nextInt();

    int[][] nums = new int[row][columns];

    for (int i = 0; i < row; i++) {
        for (int j = 0; j < columns; j++) {
            System.out.print("Number " + (j + 1) + ": ");
            nums[i][j] = input.nextInt();
            output.append(" ").append(nums[i][j]);
        }
        output.append("\n");
        System.out.println("\n");

    }

    System.out.println(output);

}