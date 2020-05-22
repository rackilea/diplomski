public static void main(String[] args) {
    int values[][] = new int[3][4];
    for (int i = 0; i < values.length; i++) {
        // do the for in the row according to the column size
        for (int j = 0; j < values[i].length; j++) {
            // multiple the random by 10 and then cast to in
            values[i][j] = ((int) (Math.random() * 10));
            System.out.print(values[i][j]);
        }
        // add a new line
        System.out.println();
    }
    System.out.println("Done");
}