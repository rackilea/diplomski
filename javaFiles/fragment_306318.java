public class JasperReportIntro {
public static void main(String[] args) {
    JasperReport jasperReport;
    JasperPrint jasperPrint;
    ArrayList<Purchase> list1 = new ArrayList<Purchase>();
    ArrayList<Purchase> list2 = new ArrayList<Purchase>();
    for(int i=0;i<20;i++) {
        Purchase purchase = new Purchase();
        purchase.setName("Vivek" + i);
        purchase.setRemark("This is remark" + i);
        purchase.setDiscount(10.0);
        purchase.setId(i);
        list1.add(purchase);
    }
    for(int i=0;i<20;i++) {
        Purchase purchase = new Purchase();
        purchase.setName("yadav" + i);
        purchase.setRemark("This is remark" + i);
        purchase.setDiscount(10.0);
        purchase.setId(i);
        list2.add(purchase);
    }

    try {
        jasperReport = JasperCompileManager.compileReport("path/to/report.jrxml");

        Map<String, List> result = new HashMap<String, List>();

        JRDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(list1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dataForSubreport1",list1);
        map.put("dataForSubreport2",list2);
        jasperPrint = JasperFillManager.fillReport(jasperReport,map, beanCollectionDataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "path/to/simple_report.pdf");
        System.out.println("Completed");
    } catch (JRException e) {
        e.printStackTrace();
    }
}
}