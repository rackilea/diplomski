public static void width(int width){
    int num = width - 2;
    System.out.print("x");      // Print the leftmost 'x'
    while(num > 0){             // Repeat for each column
        System.out.print(" ");  // Print a space
        num--;
    }
    System.out.println("x"); // Print the rightmost 'x' and change line
}
public static void main(String[] args) {
    input();
    topBottom(width);          // Print header
    System.out.println();
    int rows = length - 2;
    while (rows > 0) {         // Repeat for each of the rows, minus 2 (top and bottom)
        width(width);
        rows--;
    }
    topBottom(width);          // Print footer
    System.out.println();
}