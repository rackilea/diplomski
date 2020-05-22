public static void main(String[] args) {
    Locale locale = new Locale("ja", "JP", "JP");
    Calendar now = Calendar.getInstance(locale);
    Map<String, Integer> eras = now.getDisplayNames(Calendar.ERA, Calendar.LONG, new Locale("en"));
    for (Map.Entry<String, Integer> era : eras.entrySet()) {
        Integer eraIndex = era.getValue();
        String eraName = era.getKey();
        System.out.printf("Era #%d [%s]%n", eraIndex, eraName);
        now.set(Calendar.ERA, eraIndex);
        now.set(Calendar.YEAR, 1);
        now.set(Calendar.DAY_OF_YEAR, 1);
        System.out.printf("Actual max year in era is %d%n", now.getActualMaximum(Calendar.YEAR));
    }
}