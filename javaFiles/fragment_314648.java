public class TimeInterval {
    private final Date validFrom;
    private final Date validTo;

    public TimeInterval(Date validFrom, Date validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Date getStart() {
        return validFrom;
    }

    public Date getEnd() {
        return validTo;
    }

    @Override
    public String toString() {
        return "[" + validFrom + " - " + validTo + "]";
    }
}