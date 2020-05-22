// Don’t set default locale from production code, it’s for demonstration only
    Locale.setDefault(Locale.forLanguageTag("ar-SD"));

    WeekFields wf = WeekFields.of(Locale.getDefault());
    DateTimeFormatter formatter = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)
            .withLocale(Locale.ENGLISH);

    ZonedDateTime inputZonedDateTime
            = ZonedDateTime.of(2019, 3, 3, 12, 0, 0, 0, ZoneId.of("Asia/Amman"));
    ZonedDateTime flattenedDateTime = inputZonedDateTime.with(wf.dayOfWeek(), 1);
    System.out.println("First day of week in "
            + Locale.getDefault().getDisplayCountry(Locale.ENGLISH)
            + " is " + flattenedDateTime.format(formatter));