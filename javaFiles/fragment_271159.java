JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(yourJasperFilePath);

Map<String, Object> parameters = new HashMap<>();
// set your parameters

Class.forName("com.mysql.jdbc.Driver");
Connection con = ...; // possibly get a connection

byte[] report = JasperRunManager.runReportToPdf(jasperReport, parameters, con); // pass the report, the report parameters, and a connection 
// this will fill the byte[] with the produced report

FileOutputStream out = new FileOutputStream(somePath);
out.write(report);
out.close();