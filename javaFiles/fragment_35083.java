public class SubRecordData extends RecordData {
    private SimpleDateFormat dateFormat;

    public SubRecordData(String pattern) {
        this.dateFormat = new SimpleDateFormat(pattern);
    }

    // broken: when this method is called by the base class constructor, 
    // dateFormat is still null
    @Override
    protected SimpleDateFormat getDateFormat() {
        return dateFormat;
    }
}