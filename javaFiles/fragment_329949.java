private static final String UK = "UK";
private static final String GE = "GE";
private static final String FR = "FR";
private static final String IT = "IT";

private static final Map<String, String> COUNTRIES;
static {
    final Map<String, String> countries = new HashMap<>();
    countries.put(UK, "United Kingdom");
    countries.put(GE, "Germany");
    countries.put(FR, "France");
    countries.put(IT, "Italy");
    COUNTRIES = Collections.unmodifiableMap(countries);
}