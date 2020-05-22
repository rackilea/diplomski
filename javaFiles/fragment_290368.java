public static void main(String[] args) {
        String dateTime = "23.02.2015 14:06:30 +01:00";
        DateTimeFormatter dtf = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss Z");

        DateTime jodatime = dtf.withZone( DateTimeZone.forID( "Europe/Prague" ) ).parseDateTime(dateTime);
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println(dtfOut.withZone( DateTimeZone.forID( "Europe/Prague" ) ).print(jodatime));


        DateTime resultDateTime = jodatime.plusHours(1);
        System.out.println(dtfOut.withZone( DateTimeZone.forID( "Europe/Prague" ) ).print(resultDateTime));
    }