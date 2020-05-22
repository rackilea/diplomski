public class Plan {

    private final double BASIC_RATE;
    private final int BASIC_MINUTE;
    private final double ADDITIONAL_LINE_RATE;
    private final double RATE_PER_EXCESS_MINUTE;
    private final String PLAN_NAME;

    public Plan(double BASIC_RATE, int BASIC_MINUTE,
            double ADDITIONAL_LINE_RATE, double RATE_PER_EXCESS_MINUTE,
            String PLAN_NAME) {
        this.BASIC_RATE = BASIC_RATE;
        this.BASIC_MINUTE = BASIC_MINUTE;
        this.ADDITIONAL_LINE_RATE = ADDITIONAL_LINE_RATE;
        this.RATE_PER_EXCESS_MINUTE = RATE_PER_EXCESS_MINUTE;
        this.PLAN_NAME = PLAN_NAME;
    }

    public double getBasicRate() {
        return BASIC_RATE;
    }

    public int getBasicMinute() {
        return BASIC_MINUTE;
    }

    public double getAdditionalLineRate() {
        return ADDITIONAL_LINE_RATE;
    }

    public double getRatePerExcessMinute() {
        return RATE_PER_EXCESS_MINUTE;
    }

    public String getPlanName() {
        return PLAN_NAME;
    }
}