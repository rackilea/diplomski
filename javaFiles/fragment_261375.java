for (int i = 0; i < table.length; i++) {
    for (int j = 0; j < table[i].length; j++) {
        System.out.print("Write a name of a fruit: ");
        String word = read.nextLine();
        table[i][j] = word;
    }
}