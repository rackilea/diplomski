public class Test {
    private long timepoint;
    private String name;
    private String parameter;
    private double value;

    public Test(long timepoint, String name, String parameter, double value) {
        this.timepoint = timepoint;
        this.name = name;
        this.parameter = parameter;
        this.value = value;
    }

    public long getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(long timepoint) {
        this.timepoint = timepoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}