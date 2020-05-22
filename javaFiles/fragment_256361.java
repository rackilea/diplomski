public class InvertedTriangle {
    static int iteration = 0;

    public static void printDiamond(int n) {
        int numberOfBlanks = n - iteration;
        int numberOfInnerBlanks = iteration > 0 ? iteration * 2 - 1 : 0;
        String blank = new String(new char[numberOfBlanks]).replace("\0", " ");
        String innerBlank = new String(new char[numberOfInnerBlanks]).replace("\0", " ");
        String star = "*";
        String row = iteration == n - 1 ? blank + new String(new char[n * 2 - 1]).replace("\0", "*") + blank : iteration > 0 ? blank + star + innerBlank + star + blank : blank + star + blank;

        iteration++;
        if (iteration < n) {
            printDiamond(n);
        }
        // printing the rows backward
        System.out.println(row);
    }

    public static void main(String[] args) {
        printDiamond(10);
    }
}