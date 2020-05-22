public static void main(String[] args) {


    //int num = Integer.parseInt(args[0]);
    int num = 5; // for test

    // creating 2d array
    int[][] figures = new int[num][num];

    // filling the array
    for(int row=0; row<figures.length; ++row) {
        for(int col=0; col<figures[row].length; ++col) {
            figures[row][col] = (row + col) % num + 1; 
        }
    }

    // printing the array
    for(int row=0; row<figures.length; ++row) {

        // printing border
        for(int col=0; col<figures[row].length; ++col) {
            System.out.print("+-");
        }
        System.out.println("+");

        // printing data row
        System.out.print("|");
        for(int col=0; col<figures[row].length; ++col) {
            System.out.print(figures[row][col]);
            System.out.print("|");
        }
        System.out.println();
    }

    // printing final border
    for(int col=0; col<figures[0].length; ++col) {
        System.out.print("+-");
    }
    System.out.println("+");


}