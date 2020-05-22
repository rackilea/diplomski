private static void printLocalizedDate(Locale locale) {
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
    if (df instanceof SimpleDateFormat)
        df = new SimpleDateFormat(
                ((SimpleDateFormat) df).toPattern().replace("yy", "yyyy")
        );
    System.out.println(df.format(new Date()));
}

    printLocalizedDate(Locale.getDefault());
    printLocalizedDate(Locale.GERMANY);