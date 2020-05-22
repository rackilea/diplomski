public class MyCustomObject implements Serializable {
    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setStartDate(Date theDate) {
        this.startDate = theDate;
    }

    public void setEndDate(Date theDate) {
        this.endDate = theDate;
    }
}