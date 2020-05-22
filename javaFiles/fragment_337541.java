package org.chillies.reports;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
public class JasperReportsIntro {
public static void main(String[] args) {
Purchase purchase = new Purchase();
    purchase.setName("Vivek");
    purchase.setRemark("This is remark");
    purchase.setDiscount(10.0);
    purchase.setId(20);
ArrayList<Purchase> list = new ArrayList<Purchase>();
        list.add(purchase);
        JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list);
JasperReport jasperReport;
JasperPrint jasperPrint;
try {
    jasperReport = JasperCompileManager.compileReport("jrxmls"
            + File.separator + "PurchaseReport.jrxml");
    jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), beanCollectionDataSource);
    JasperExportManager.exportReportToPdfFile(jasperPrint,
            "Genratedreports/simple_report.pdf");
    System.out.println("Completed");
} catch (JRException e) {
    e.printStackTrace();
  }
 }
}