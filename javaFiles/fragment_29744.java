public class ReportBuilder {
    private Report report;
    public ReportBuilder() {
        this.report = new Report();
    }
    public ReportBuilder setName(String unparsedString) {
        // do the parsing
        report.setName(parsedString);
        return this;
    }
    public ReportBuilder setValue(String unparsedString) {
        // do the parsing
        report.setValue(parsedString);
        return this;
    }
    public Report build() {
        return report;
    }
}

Report report = new ReportBuilder()
                   .setName(unparsedString)
                   .setValue(unparsedString)
                   .build();
dao.saveReport(report);