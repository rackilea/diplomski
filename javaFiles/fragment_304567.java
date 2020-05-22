public class AuthorReport {

    public static void generate() {
        try {
           String reportSource = "resources/authorReport.jasper";

           JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);

           Map<String, Object> params = new HashMap<String, Object>();
           params.put(JRParameter.REPORT_FILE_RESOLVER, new SimpleFileResolver(new File(youPath)));

           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

           JasperExportManager.exportReportToHtmlFile(jasperPrint, "hello_report.html");
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}