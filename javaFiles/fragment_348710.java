private static String parseReport(String reportResponse) throws Exception {
String urlReport = null;
try {
    Document document = DocumentHelper.parseText(reportResponse);
    Node node = document.selectSingleNode("/report/uuid");
    String uuid = node.getText();
    node = document.selectSingleNode("/report/totalPages");
    Integer totalPages = Integer.parseInt(node.getText());
    if (totalPages == 0) {
        throw new Exception("Error generando reporte");
    }
    urlReport = serverUrl + "/report/" + uuid + "?file=report";
} catch (DocumentException e) {
    throw e;
}
return urlReport;