private static final int[] SCHEDULE = new int[] {1, 0, 1, 0, 1, 1, 1};

public static void main(String[] args) {
    LocalDate testDate = LocalDate.of(2016, Month.OCTOBER, 8);
    System.out.println("testDate = " + testDate);

    DayOfWeek dayOfWeek = testDate.getDayOfWeek();
    System.out.println("Day of week = " + dayOfWeek);

    System.out.println("The bus " + (1 == SCHEDULE[dayOfWeek.getValue()-1] ? "goes" : "does not go") + " on " + testDate);
}