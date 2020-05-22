String input = "8\r\n" +
               "RED\r\n" +
               "8 0 0 0 1 0 2 0 3 0 4 0 5 0 6 0 7\r\n" +
               "8 1 0 1 1 1 2 1 3 1 4 1 5 1 6 1 7\r\n" +
               "BLUE\r\n" +
               "8 7 0 7 1 7 2 7 3 7 4 7 5 7 6 7 7\r\n" +
               "8 6 0 6 1 6 2 6 3 6 4 6 5 6 6 6 7\r\n" +
               "6139";
try (Scanner sc = new Scanner(input)) {
    int sum = 0;
    for (int i = 0; i < 7; i++)
        sum += sc.nextLine().chars().sum();
    System.out.println("Calculated: " + sum);
    System.out.println("Last line : " + sc.nextLine());
}