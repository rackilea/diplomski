LocalTime morning = LocalTime.of(05, 00);
LocalTime evening = LocalTime.of(17, 00);
LocalTime time = LocalTime.now();
Duration fromMorning = Duration.between(morning, time);
Duration toEvening = Duration.between(evening, time);
if(fromMorning.isNegative()) toEvening=toEvening.plusDays(1);
else if(!toEvening.isNegative()) fromMorning=fromMorning.minusDays(1);
System.out.println(format(fromMorning, "morning"));
System.out.println(format(toEvening, "evening"));