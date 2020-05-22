import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportFilter {

    public static void main(String[] args) {
        Report report1 = new Report();      
        report1.setCreated(Timestamp.from(Instant.EPOCH));
        report1.setValue((short) 100);

        Report report2 = new Report();
        report2.setCreated(Timestamp.from(Instant.EPOCH.plus(10, ChronoUnit.DAYS)));
        report2.setValue((short) 200);

        Report report3 = new Report();
        report3.setCreated(Timestamp.from(Instant.EPOCH.plus(40, ChronoUnit.DAYS)));
        report3.setValue((short) 300);

        Report report4 = new Report();
        report4.setCreated(Timestamp.from(Instant.EPOCH.plus(40, ChronoUnit.DAYS)));
        report4.setValue((short) 400);

        List<Report> reports = Arrays.asList(report1, report2, report3, report4);
        List<Report> filteredReports = oneReportPerMonthFilter(reports); 
        System.out.println(filteredReports);
    }

    public static List<Report> oneReportPerMonthFilter(List<Report> reports) {
        Set<String> found = new HashSet<>();
        return reports.stream().filter(r -> found.add(getCreatedYearMonth(r))).collect(Collectors.toList());    
    }

    public static String getCreatedYearMonth(Report report) {
        //Or you can use SimpleDateFormat to extract Year & Month
        Calendar cal = Calendar.getInstance();
        cal.setTime(report.getCreated());
        return "" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH);
    }
}

class Report {
    private Timestamp created;
    private short value;    

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created){
        this.created = created;
    }


    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Report [created=" + created + ", value=" + value + "]";
    }
}