@XmlRootElement(name = "TABLE")
public class Table {
    private List<Record> records = new ArrayList<>();

    @XmlElementWrapper(name = "RECORDS")
    @XmlElement(name = "RECORD")
    public List<Record> getRecords() {
        return this.records;
    }
    public void setRecords(List<Record> records) {
        this.records = records;
    }
}