public class PeriodInformation {

    PeriodInformation(Calendar timestamp,
                      int periodSpendingCount,
                      float periodSpendingSum) {
        this.timestamp = timestamp;
        this.periodSpendingCount = periodSpendingCount;
        this.periodSpendingSum = periodSpendingSum;
    }

    @ColumnInfo(name = "DateTime")
    public final Calendar timestamp;
    @ColumnInfo(name = "SpendingCount")
    public Integer periodSpendingCount;
    @ColumnInfo(name = "SpendingSum")
    public Float periodSpendingSum;

    @Override
    public String toString() {
        final DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        String date = timestamp == null ? "null" : dateInstance.format(timestamp.getTime());
        return "PeriodInformation{" +
               "timestamp='" + date + '\'' +
               ", periodSpendingCount=" + periodSpendingCount +
               ", periodSpendingSum=" + periodSpendingSum +
               '}';
    }
}