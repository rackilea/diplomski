private static final LocalDate sheSayYes = LocalDate.of(2008, Month.APRIL,
        26);
private static final LocalDate today = LocalDate.now();

public static void main(String[] args) {
    Period p = Period.between(sheSayYes, today);
    System.out.printf("%d years, %d months, %d days%n", p.getYears(),
            p.getMonths(), p.getDays());
    System.out.println(ChronoUnit.DAYS.between(sheSayYes, today));
}