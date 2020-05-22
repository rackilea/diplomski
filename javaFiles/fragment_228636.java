String date = "2019-07-04 00:32:08:627158";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
    "yyyy-MM-dd HH:m:ss:nnnnnn");
LocalDateTime ldt = LocalDateTime.parse(date, formatter);
DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern(
    "dd-MMM-yy hh.mm.ss.nnnnnn a");
System.out.println(outFormatter.format(ldt));