Date date = // Date from date picker
LocalDate ld = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

//LocalDate ld = LocalDate.of(1972, Month.MARCH, 8);
Period p = Period.between(ld, LocalDate.now());
System.out.println(p.getYears());
System.out.println(p.getMonths());
System.out.println(p.getDays());