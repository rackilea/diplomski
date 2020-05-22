public interface ReportBuilder<T extends Component> {
    public Report buildReport(List<T> components);
}

public class PDFReportBuilder implements ReportBuilder<PDFComponent> {
    public Report buildReport(List<PDFComponent> components);
}