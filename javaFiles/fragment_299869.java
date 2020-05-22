java.time.LocalTime localTime = java.time.LocalTime.now();
long epochMilli = localTime.atDate(java.time.LocalDate.EPOCH)
                           .atZone(java.time.ZoneId.systemDefault())
                           .toInstant()
                           .toEpochMilli();
java.sql.Time sqlTime = new java.sql.Time(epochMilli);

System.out.println(localTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")));
System.out.println(new SimpleDateFormat("HH:mm:ss.SSS").format(sqlTime));