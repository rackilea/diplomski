LocalDateTime now = LocalDateTime.now();
Duration fiveDays = Duration.ofDays(5);
Period oneYearTwoMonthsThreeDays = Period.of(1, 2, 3);

System.out.println(now);
System.out.println(now.plus(fiveDays));
System.out.println(now.plus(oneYearTwoMonthsThreeDays));