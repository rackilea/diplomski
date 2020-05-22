private static void printX(int width, int level) {
    if (width < 2) {
        if (width == 1) {
            printRow(width, level);
        }
        return;
    }
    printRow(width, level);
    printX(width - 2, level+1);
    printRow(width, level);
}

private static void printX(int width) {
    printX(width, 0);
}

public static void main(String[] args) {
    printX(7);
}