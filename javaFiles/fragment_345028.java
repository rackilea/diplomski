@ReportType(reportName = "html")
public class HTMLReport {

    //Can be potentially moved to parent class of all reports.
    @JsonProperty("reportName")
    private String reportName;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}

public class ReportName {

    public static void main(String[] args) throws Exception, JsonMappingException, IOException {
        HTMLReport r = new HTMLReport();

        ReportType type = r.getClass().getAnnotation(ReportType.class);
        String reportName = type.reportName();
        r.setReportName(reportName);

        ObjectMapper m = new ObjectMapper();
        m.writeValue(System.out, r); //Produces {"reportName":"html"}
    }

}