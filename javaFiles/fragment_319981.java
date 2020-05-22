import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
public static void main(String[] args) {
 try {
     HashMap hm = new HashMap < > ();
      String filePath = System.getProperty("user.dir") + "\\somexmldatasource.xml";
      InputStream inputStream = new FileInputStream(new File(filePath));
      JRXmlDataSource ds = new JRXmlDataSource(inputStream, "/some/xpath/query");
      JasperReport jasperReport;
      JasperPrint jasperPrint;
      jasperReport = JasperCompileManager.compileReport(System.getProperty("user.dir") + "\\yourreport.jrxml");
      jasperPrint = JasperFillManager.fillReport(jasperReport, hm, ds);
      JasperExportManager.exportReportToPdfFile(jasperPrint, "someoutputpath\\simple_report.pdf");
 } catch (Exception e) {
      e.printStackTrace();
 }

}