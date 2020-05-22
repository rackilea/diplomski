public class InvertedTriangle {
    static int iteration = 0;
    public static void printDiamond(int n) {
        int numberOfBlanks = n - iteration;
        int numberOfStars = iteration * 2 + 1;
        String blank = new String(new char[numberOfBlanks]).replace("\0", " ");
        String star = new String(new char[numberOfStars]).replace("\0", "*");
        String row = blank + star + blank;

        iteration++;
        if (iteration < n) {
            printDiamond(n);
        }
        // printing the rows backward
        System.out.println(row);
    }

    public static void main(String[] args) {
        printDiamond(5);
    }
}