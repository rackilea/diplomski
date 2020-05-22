public class Moment{
    private Timestamp createTimeStamp;

    public Timestamp getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(long createTimeStamp) {
        this.createTimeStamp = new Timestamp(createTimeStamp * 1000);
    }
}