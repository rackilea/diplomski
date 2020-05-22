public static void main(String[] args) {
    int[][] x = new int[1][5];
    int k, z = 0, y, item, item1;

    System.out.println("Enter 5 numbers: ");

    for (y = 0; y < 5; y++)
        for (z = 0; z < 1; z++)
            x[z][y] = console.nextInt();


    System.out.println("Search Number: ");
    k = console.nextInt();
    boolean isFound = false;
    for (item = 0; item < 5; item++) {
        for (item1 = 0; item1 < 1; item1++) {
            if (x[item1][item] == k) {
                System.out.println(" Position: " + (item + 1));
                isFound = true;
                break;
            }
        }
    }

    if (!isFound)
        System.out.print("Number not found...");
}