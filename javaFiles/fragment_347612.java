ZonedDateTime dateTime = ZonedDateTime.of(LocalDate.now(),LocalTime.now() ,ZoneId.of("UTC"));

System.out.println(dateTime);  //2019-11-19T10:48:12.324356Z[UTC]

ZonedDateTime result = dateTime.withZoneSameLocal(ZoneId.of("America/Chicago"));  // provide ZoneId.systemDefault()

System.out.println(result);    //2019-11-19T10:48:12.324356-06:00[America/Chicago]