public static void main(String[] args) {

    System.out.println("Pentagonal Numbers are: ");
    getPentagonalNumber(100);
}

public static void getPentagonalNumber(int n) {


    final int numPerLine = 10;
    int pentNum;

    for (int i = 1; i <= n; i++) {
        pentNum = ((i * (3 * i - 1)) / 2);
        System.out.print(" " + pentNum);
        if (i % numPerLine == 0)
            System.out.print("\n");
    }

}