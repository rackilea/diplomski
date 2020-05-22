public abstract class RecordData {
    private MyDate mDate;

    protected RecordData(String datePattern) {
        this.mDate = new MyDate(new SimpleDateFormat(datePattern));
    }
}