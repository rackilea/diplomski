public static void main(String[] args) {
    for (int i = 7; i >= 1; i--) {
        for (int k = 7; k >= i; k--) {
            System.out.print(" ");  // Print 7-i number of spaces before start of each line
        }
        System.out.print(i); // Print i
        for (int j = 1; j <= i*2; j++) {
            System.out.print(" "); // Print i*2 number of spaces after printing i
        }
        System.out.println(i); // Print i
    }
}