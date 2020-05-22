class Producttable {

public static void main(String[] args) {

    int tableSize = 4;

    printMultiplicationTable(tableSize);
}

public static void printMultiplicationTable(int tableSize) {

    // first print the top header row
    System.out.format("      ");

    for(int i = 1; i<=tableSize;i++ ) {

        char c = (char)(64+i);
        System.out.format("%4s",String.valueOf(c));
    }
    System.out.println();

    System.out.println("__________________________");

    for(int i = 1 ;i<=tableSize;i++) {
        // print left most column first

        System.out.format("%4d |",i);

        for(int j=1;j<=tableSize;j++) {
            System.out.format("%4d",i*j);
        }
        System.out.println();
    }
}
}