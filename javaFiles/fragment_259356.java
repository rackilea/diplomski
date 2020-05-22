public class UniqueZone {

    private ZoneId zone;

    public UniqueZone(ZoneId zone) {
        this.zone = zone;
    }

    public ZoneId getZone() {
        return zone;
    }

    // hashcode and equals use the ZoneRules
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((zone == null) ? 0 : zone.getRules().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof UniqueZone))
            return false;
        UniqueZone other = (UniqueZone) obj;
        if (zone == null) {
            if (other.zone != null)
                return false;
        // two zones are equal if the ZoneRules are the same
        } else if (!zone.getRules().equals(other.zone.getRules()))
            return false;
        return true;
    }
}