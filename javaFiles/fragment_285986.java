public static void main(String[] args) {
    String[][] table = {{"A", "B", "C", "D", "E"}, {"FirstClass", "50000", "2%", "No", "No"}, {"SecondClass", "100000", "5%", "Yes", "No"}, {"ThirdClass", "200000", "7%", "Yes", "No"}, {"FourthClass", "300000", "10%", "Yes", "Yes"}};

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            System.out.printf("|%-15s", table[i][j]);
        }
        System.out.println();
    }

    System.out.print("\n\n");

    outer:
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if ("No".equals(table[i][3])) {
                continue outer; //note the tag
            }
            System.out.printf("|%-15s", table[i][j]);
        }
        System.out.println();
    }
}