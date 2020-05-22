private int getInt(String prompt) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(prompt);

    int in = scanner.nextInt();
    scanner.close();
    return in;
}