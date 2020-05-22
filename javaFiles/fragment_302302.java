@XmlRootElement(name = "TABLE")
public class Table {
    private List<Record> records;

    public Table() {
        this.records = new ArrayList<>();
    }
    public Table(Record... records) {
        this.records = Arrays.asList(records);
    }

    @XmlElementWrapper(name = "RECORDS")
    @XmlElement(name = "RECORD")
    public List<Record> getRecords() {
        return this.records;
    }
    public void setRecords(List<Record> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "Table" + this.records.toString();
    }
}