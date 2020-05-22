LocalTime time1 = LocalTime.of(8, 0, 0);
LocalTime time2 = LocalTime.of(15, 0, 0);
int secondOfDayTime1 = time1.toSecondOfDay();
int secondOfDayTime2 = time2.toSecondOfDay();
Random random = new Random();
int randomSecondOfDay = secondOfDayTime1 + random.nextInt(secondOfDayTime2-secondOfDayTime1);   
LocalTime randomLocalTime = LocalTime.ofSecondOfDay(randomSecondOfDay);