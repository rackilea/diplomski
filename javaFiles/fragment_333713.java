// compare the months after rounding to the next month
LocalDate a = LocalDate.of(2017, 1, 31);
LocalDate b = LocalDate.of(2017, 2, 28);
long months = a.plus(1, ChronoUnit.MONTHS)
        .until(b.plus(1, ChronoUnit.MONTHS), ChronoUnit.MONTHS);
System.out.println(a + " until " + b + " in months: " + months);