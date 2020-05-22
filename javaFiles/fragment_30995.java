public class Date {

    private java.util.date date;

    public Date(java.util.Date date) {
        this.date = date
    }

    public int getUnixTimeStamp() {
        int unixtimestamp = (int) ((this.date.getTime()) * .001);
        return unixtimestamp;
    }