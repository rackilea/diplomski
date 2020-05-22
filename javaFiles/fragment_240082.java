for (int row = 1; row <= n; row++) {
    System.out.print(j); // Print the number of row
    for (int seat = 1; seat <= 4; seat++) {
        System.out.print(" "); // Print separator
        if (airplane[row - 1][seat - 1] == 0) {
            System.out.print("-");
        } else {
            System.out.print("X");
        }
    }
    System.out.println(""); // Go to the next line
}