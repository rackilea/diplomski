public static void main(String[] args) throws Exception
{
    LocalDate start1 = LocalDate.of(2016, Month.FEBRUARY, 28);
    LocalDate start2 = LocalDate.of(2016, Month.FEBRUARY, 29);
    LocalDate end    = LocalDate.of(2017, Month.MARCH,     1);
    Period    year   = Period.ofYears(1);

    System.out.println(start1);
    System.out.println(start2);
    System.out.println(end);
    System.out.println(start1.plus(year));
    System.out.println(start2.plus(year));
    System.out.println(start1.until(end));
    System.out.println(start2.until(end));
}