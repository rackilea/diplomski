import static java.time.temporal.TemporalAdjusters.*;//to get functions firstDayOfMonth() and lastDayOfMonth()
...
LocalDate initialdate= ...
LocalDate localDateNow = ...
DateTimeFormatter format1 = ...

for(LocalDate date = initialdate; date.isBefore(localDateNow); date = date.plusMonths(1)) { //Could be plusdays if you want to interate day by day

    LocalDate dtini = date.with(firstDayOfMonth());
    LocalDate dtend = dtini.with(lastDayOfMonth());
    //LocalDate dtend = dtini.plusDays(14); //If you want from day 1 do 15

    //TODO: Use dtini and dtend to your like
    System.out.println("dtini =" + format1.format(dtini));
    System.out.println("dtend =" + format1.format(dtend));

}