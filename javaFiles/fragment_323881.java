public enum SolutionType {
    RMS, CPA, BUSINESS_DRIVERS("BUSINESS DRIVERS"), NA;

    private String readableName;

    private SolutionType() {
        this.readableName = this.name();
    }

    private SolutionType(String name) {
        this.readableName = name;
    }

    @Override
    public String toString() {
        return this.readableName;
    }
}