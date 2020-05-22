public class Currency {

    private String currId;

    /**
     * Get the value of currId
     *
     * @return the value of currId
     */
    public String getCurrId() {
        return currId;
    }

    /**
     * Set the value of currId
     *
     * @param currId new value of currId
     */
    public void setCurrId(String currId) {
        this.currId = currId;
    }

        private double rate;

    /**
     * Get the value of rate
     *
     * @return the value of rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * Set the value of rate
     *
     * @param rate new value of rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    private String charCode;

    /**
     * Get the value of charCode
     *
     * @return the value of charCode
     */
    public String getCharCode() {
        return charCode;
    }

    /**
     * Set the value of charCode
     *
     * @param charCode new value of charCode
     */
    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @Override
    public String toString() {
        return "Currency{" + "currId=" + currId + ", rate=" + rate + ", charCode=" + charCode + '}';
    }

}