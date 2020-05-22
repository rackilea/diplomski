Map<String, DefaultDateTimeFormatInfo> formats = new HashMap<String, DefaultDateTimeFormatInfo>();

    DefaultDateTimeFormatInfo formatDE = new DateTimeFormatInfoImpl_de();
    DefaultDateTimeFormatInfo formatEN = new DateTimeFormatInfoImpl_en();
    DefaultDateTimeFormatInfo formatFR = new DateTimeFormatInfoImpl_fr();
    DefaultDateTimeFormatInfo formatES = new DateTimeFormatInfoImpl_es();
    DefaultDateTimeFormatInfo formatZH = new DateTimeFormatInfoImpl_zh();
    DefaultDateTimeFormatInfo formatRU = new DateTimeFormatInfoImpl_ru();

    formats.put("de", formatDE);
    formats.put("en", formatEN);
    formats.put("fr", formatFR);
    formats.put("es", formatES);
    formats.put("zh", formatZH);
    formats.put("ru", formatRU);

    String language = getLanguage();

    DefaultDateTimeFormatInfo format = formats.get(language);
    DateTimeFormat dateFormat = null;
    if (format == null) {
        dateFormat = DateTimeFormat.getFormat(LocaleInfo.getCurrentLocale()
                .getDateTimeFormatInfo().dateFormatLong());
    } else {
        dateFormat = DateTimeFormat.getFormat(format.dateFormatFull());
    }

    System.out.println(dateFormat.format(new Date()));

    DateBox dateBox = new DateBox();
    dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
    RootPanel.get().add(dateBox);