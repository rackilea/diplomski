public static void test(int selectedDayOfMonth) {
    LocalDate date = LocalDate.of(2001, Month.JANUARY, selectedDayOfMonth);
    System.out.println(date);
    for (int i = 0; i < 5; i++) {
        date = next(date, selectedDayOfMonth);
        System.out.println(date);
    }
    System.out.println();
}