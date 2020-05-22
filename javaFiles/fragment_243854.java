String time1 = "2017-10-06T17:48:23.558";
// convert String to LocalDateTime
LocalDateTime localDateTime = LocalDateTime.parse(time1);
// parse it to a specified format
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm:ss");
System.out.println(localDateTime.format(formatter));