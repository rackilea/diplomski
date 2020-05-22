try {
    Scanner io = new Scanner(System.in);
    String input = io.next();
    // Note StringIndexOutOfBoundsException
    int year = Integer.parseInt(input.substring(0, 2));
    int month = Integer.parseInt(input.substring(2, 4));
    System.out.println("year: " +  year + "month: " +  month);
} catch (Exception e) {
    e.printStackTrace();
}