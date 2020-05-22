@Entity
public class Spending {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "calendarDate")
    public Calendar timestamp;

    @ColumnInfo(name = "value")
    public float value;

    public Spending(@NonNull Calendar timestamp, float value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    @Override
    public String toString() {
        final DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        String date = timestamp == null ? "null" : dateInstance.format(timestamp.getTime());


        return "Spending{" +
               "uid=" + uid +
               ", timestamp='" + date + '\'' +
               ", value=" + value +
               '}';
    }
}