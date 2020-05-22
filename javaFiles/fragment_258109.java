static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

public static void main(String[] args) {
    LocalDateTime begin = LocalDateTime.parse("21.01.2018 00:00", formatter);
    LocalDateTime end = LocalDateTime.parse("20.03.2018 00:00", formatter);
    list(begin, end).forEach(System.out::println);
}

// And get
21.01.2018 00:00 > 01.02.2018 00:00
01.02.2018 00:00 > 01.03.2018 00:00
01.03.2018 00:00 > 20.03.2018 00:00