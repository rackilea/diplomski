Date date = // Date from date picker
LocalDate ld = LocalDate.fromDateFields(date);

Period p = Period.fieldDifference(ld, LocalDate.now());
System.out.println(p.getYears());
System.out.println(p.getMonths());
System.out.println(p.getDays());