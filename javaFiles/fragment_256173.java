//String pdfFileName = "D:/JasperReports/StatisticsrReport.pdf";
response.setContentType("application/x-download");
response.addHeader("Content-disposition", "attachment; filename=StatisticsrReport1.pdf");
OutputStream out = response.getOutputStream();
JasperExportManager.exportReportToPdfStream(jasperPrint,out);//export PDF directly
//return null ActionForward, no extra data is appended to output stream