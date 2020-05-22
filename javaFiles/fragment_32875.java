public enum WeekEnumElaborate {
    SUNDAY("SUN", "Funday"), MONDAY("MON", "Moot"), TUESDAY("TUE", "Terrible"), 
    WEDNESDAY("WED", "Weed"), THURSDAY("THUR", "Terrific"), FRIDAY("FRI", "Fairy"),
    SATURDAY("SAT", "Jollyday"), R$00("R$00", "RX100 Day");

    private final String shortForm;
    private final String description;

    private WeekEnumElaborate(String shortForm, String description) {
        this.shortForm = shortForm;
        this.description = description;
    }

    public String getShortForm() {
        return this.shortForm.toLowerCase();
    }

    public String getDescription() {
        return new StringBuilder(getShortForm()).append(' ').append(this.description).toString();
    }

    public String getFurtherDescription(String desc) {
        if (this == MONDAY) {
            return "I do not want to work on this day!!!!";
        }
        return getDescription();
    }
}