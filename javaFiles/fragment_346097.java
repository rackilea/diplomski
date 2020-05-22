LocalTime start = LocalTime.parse("16:08:39.660");
LocalTime end = LocalTime.parse("16:08:52.452");
Duration duration = Duration.between(start, end);

System.out.println(duration.toMillis()); // 12792
System.out.println(duration.toMillis() / 1000.00); // 12.792
System.out.println(duration.toSeconds()); // 12