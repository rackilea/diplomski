public static void main(String[] args) {
    String first = "12/21/2020 12:12:12 PM";
    String second = "1/12/2020 2:6:8 PM";
    String third = "10/2/2020 10:50:8 AM";

    DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("[MM/dd/yyyy HH:mm:ss a][M/dd/yyyy h:m:s a][MM/d/yyyy HH:mm:s a]");

    System.out.println(LocalDateTime.parse(first, dtf));
    System.out.println(LocalDateTime.parse(second, dtf));
    System.out.println(LocalDateTime.parse(third, dtf));
}