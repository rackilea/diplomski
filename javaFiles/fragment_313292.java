public enum Day {
    SUNDAY("S"),
    MONDAY("M"),
    TUESDAY("T"),
    WEDNESDAY("W"),
    THURSDAY("R"),
    FRIDAY("F"),
    SATURDAY("Y");

    private String shortName;

    private Day(String abbreviation) {
       shortName = abbreviation;
    }

    public String getShortName() {
        return shortName;
    }
};