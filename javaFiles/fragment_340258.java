public class BubbleChartTest {
    public static void main(String[] args) throws Exception {
        List<Data> dataList = new ArrayList<Data>();
        dataList.add(new Data("A", 1d, 3d, 0.3));
        dataList.add(new Data("A", 2d, 3d, 0.2));
        dataList.add(new Data("B", 5d, 6d, 0.4));
        dataList.add(new Data("B", 4d, 3d, 0.2));
        dataList.add(new Data("B", 2d, 5d, 0.1));
        dataList.add(new Data("C", 5d, 6d, 0.2));
        dataList.add(new Data("C", 2d, 3d, 0.3));
        dataList.add(new Data("C", 4d, 5d, 0.4));
        String templateFile = "resources/bubble.jrxml";
        JasperDesign design = JRXmlLoader.load(templateFile);
        JasperReport report = JasperCompileManager.compileReport(design);
        Map parameter = new HashMap();
        JasperPrint print = JasperFillManager.fillReport(report, parameter, new JRBeanCollectionDataSource(dataList));
        JasperExportManager.exportReportToPdfFile(print, "D:/temp/bubble_chart.pdf");
    }
}