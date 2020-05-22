DateTime jodaStartDate = new DateTime().withYear(2018)
                                       .withMonthOfYear(7)
                                       .withDayOfMonth(5); // 15 days from now

System.out.println(Days.daysBetween(jodaStartDate, DateTime.now())); // "P-15D"    
System.out.println(Days.daysBetween(DateTime.now(), jodaStartDate)); // "P15D"