public class Wrapper {

    private String range;
    private String majorDimension;
    private List<?> values;

    /**
     * @return the range
     */
    public String getRange() {
        return range;
    }
    /**
     * @return the values
     */
    public List<?> getValues() {
        return values;
    }
    /**
     * @param values the values to set
     */
    public void setValues(List<?> values) {
        this.values = values;
    }
    /**
     * @return the majorDimension
     */
    public String getMajorDimension() {
        return majorDimension;
    }
    /**
     * @param majorDimension the majorDimension to set
     */
    public void setMajorDimension(String majorDimension) {
        this.majorDimension = majorDimension;
    }
    /**
     * @param range the range to set
     */
    public void setRange(String range) {
        this.range = range;
    }
}