DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

String strLocalDate = "2015-10-23T03:34:40";

LocalDateTime localDate = LocalDateTime.parse(strLocalDate, formatter);

System.out.println(localDate);
System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDate));
System.out.println(DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd ").format(localDate));