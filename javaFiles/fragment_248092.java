private static void printColumn(int columnWidth, int columnHeight, int currentHeight) {
    for(int j = columnWidth;j > 0;j--) {
        if(columnHeight - currentHeight >= 0) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
    }
}