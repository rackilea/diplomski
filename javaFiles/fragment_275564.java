@ConfigurationProperties("csv")
public class CSVProperties {
    private String firstCsv;

    public String getFirstCsv() {
        return firstCsv;
    }

    public void setFirstCsv(String firstCsv) {
        this.firstCsv = firstCsv;
    }
}