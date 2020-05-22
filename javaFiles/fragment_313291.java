public enum Day {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    private String shortName;

    private Day(String abbreviation) {
       shortName = abbreviation;
    }

    public String getShortName() {
        return shortName;
    }
};