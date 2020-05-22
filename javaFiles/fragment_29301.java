private static void printRows(ArrayList<byte[]> arr) {
    int row = 0;
    for(int i = 0 ; i < arr.size() ; i++) {
        System.out.print(Arrays.toString(arr.get(i)) + "  ");
        row++;
        if(row%3 == 0)
            System.out.println();
    }
    System.out.println("\n\n");
}