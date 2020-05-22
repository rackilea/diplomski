public enum SolutionType {
    RMS, CPA, BUSINESS_DRIVERS, NA;

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
}