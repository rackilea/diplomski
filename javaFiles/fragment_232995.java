public static void main(String[] args) {
    final int numRows = 4;
    for (int row = numRows-1; row >= 0; row--) {
        for (int preSpace = numRows - row; preSpace >= 0; preSpace--) {
            System.out.print(" ");
        }
        if (row > 0) {
            System.out.print("v");
            for (int postSpace = 1; postSpace < row * 2; postSpace++) {
                System.out.print(" ");
            }
        }                   
        System.out.println("v");
    }
}