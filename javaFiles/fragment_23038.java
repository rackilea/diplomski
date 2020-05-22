JasperReport jasperReport = null;
JasperReport subReport = null;
String reportPath = "/reports/invoice/invoice_master.jasper";
String subReportPath = "/reports/invoice/invoice_sub_report.jasper";
try {
//load the the reports
jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(reportPath));

subReport = (JasperReport)JRLoader.loadObject(getClass().getResource(subReportPath));

//pass the subReport object as a parameter to the jasperReport
Map<String, Object> reportParams = new HashMap<String, Object>();
params.put("SUB_JASPER", subReport);

//finally pass the parameter map to the report.
JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, connectionOrOtherDataSource);
//... do something with jasperPrint
} catch (JRException e) {
    e.printStackTrace();
}