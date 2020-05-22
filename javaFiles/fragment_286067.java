public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    reader.useDelimiter(System.getProperty("line.separator"));
    List<Integer> list = new ArrayList<>();
    System.out.println("Enter Integer: ");

    while (true) {
        try {
            int n = reader.nextInt();
            list.add(Integer.valueOf(n));
        } catch (InputMismatchException exception) {
            System.out.println("Not an integer, please try again. Press enter key to exit");
            if (reader.next().isEmpty()) {
                break;
            }
        }
    }

    System.out.println(list);
    reader.close();
}