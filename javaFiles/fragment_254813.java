public static InputStream generatePdfByteArrayFromJasper(List<InputStream> reportStreams, Collection dataSource, HashMap<String, Object> parameters)
throws JRException {
    List<JasperPrint> jasperPrints = new ArrayList<>();
    for (InputStream is : reportStreams) {
        JRDataSource datasource = new JRBeanCollectionDataSource(dataSource, true);
        HashMap<String, Object> reportParameters = new HashMap<>(parameters);
        JasperPrint jasperPrint = JasperFillManager.fillReport(is, reportParameters, datasource);
        jasperPrints.add(jasperPrint);
    }