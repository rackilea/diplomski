//printFileName = JasperFillManager.fillReportToFile(reportPath, params);
jasperPrint = JasperFillManager.fillReport(reportPath, params);
if (jasperPrint != null) {
    //JasperExportManager.exportReportToPdfFile(printFileName, illufilename);
     JasperExportManager.exportReportToPdfFile(jasperPrint, illufilename);
}