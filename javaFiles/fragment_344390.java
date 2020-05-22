String input = "3.06.2019-20.06.2019";
if (input.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}-\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
    String[] dates = input.split("-");
    System.out.println("date1: " + dates[0]);
    System.out.println("date2: " + dates[1]);
}