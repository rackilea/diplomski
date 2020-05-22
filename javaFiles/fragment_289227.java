ZoneId zone = ZoneId.of("America/Recife");
Locale brazil = Locale.forLanguageTag("pt-BR");
DateTimeFormatter formatter = DateTimeFormatter
    .ofLocalizedDateTime(FormatStyle.FULL)
    .withLocale(brazil);
String formatted = i.atZone(zone).format(formatter);
System.out.println(formatted);