private static Map<Locale, String> formats = new HashMap<Locale, String>();

static {
    formats.put(new Locale("en_US"), "dd/MM/yyyy");
    formats.put(new Locale("da_DK"), "dd.MM.yyyy");
}