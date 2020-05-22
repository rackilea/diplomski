String input="2017-04-05T12:38:35.585";

LocalDateTime ldt = ISODateTimeFormat.localDateOptionalTimeParser()
                    .withLocale(Locale.ENGLISH)
                    .parseLocalDateTime(input);

System.out.println(ldt.toLocalDate());//prints 2017-04-05