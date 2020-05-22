public enum Currency {
    NIS("Name1", 0, "NIS", 1, 2), 
    USD("Name2", 1, "USD", 1, 2), 
    EUR("Name3", 2, "EUR", 1, 2), 
    GBP("Name4", 3, "GBP", 1, 2), 
    JPY("Name5", 4, "JPY", 1, 2), 
    AUD("Name6", 5, "AUD", 1, 2), 
    CAD("Name7", 6, "CAD", 1, 2), 
    DKK("Name8", 7, "DKK", 1, 2), 
    NOK("Name9", 8, "NOK", 1, 2), 
    ZAR("Name10", 9, "ZAR", 1, 2), 
    SEK("Name11", 10, "SEK", 1, 2), 
    CHF("Name12", 11, "CHF", 1, 2), 
    JOD("Name13", 12, "JOD", 1, 2), 
    LBP("Name14", 13, "LBP", 1, 2), 
    EGP("Name15", 14, "EGP", 1, 2);

    private final String name;
    private final int unit;
    private final String country;
    private final double rate;
    private final double change;

    private Currency(String name, int unit, String country, double rate, double change) {
        this.name = name;
        this.unit = unit;
        this.country = country;
        this.rate = rate;
        this.change = change;
    }

    public String getName() {
        return name;
    }

    public int getUnit() {
        return unit;
    }

    public String getCountry() {
        return country;
    }

    public double getRate() {
        return rate;
    }

    public double getChange() {
        return change;
    }
}