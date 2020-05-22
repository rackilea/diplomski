public final class CompositeKey {
    private final String ruleType;
    private final Calendar timeStamp;

    public CompositeKey(String ruleType, Calendar timeStamp) {
        this.ruleType = Objects.requireNonNull(ruleType);
        this.timeStamp = (Calendar) Objects.requireNonNull(timeStamp).clone();
    }

    public String ruleType() { return ruleType; }
    public Calendar timeStamp() { return (Calendar) timeStamp.clone(); }

    @Override public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CompositeKey other = (CompositeKey) obj;
        return Objects.equals(ruleType, other.ruleType) && Objects.equals(timeStamp, other.timeStamp);
    }

    @Override public int hashCode() { return Objects.hash(ruleType, timeStamp); }
}