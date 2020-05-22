JasperReport ordersReport = JasperCompileManager.compileReport(srcOrdersReport);
JasperPrint jpOrdersReport = JasperFillManager.fillReport(ordersReport, ordersParamsMap, ordersDataSource);

JasperReport receiptsReport = JasperCompileManager.compileReport(srcReceiptsReport);
JasperPrint jpReceiptsReport = JasperFillManager.fillReport(receiptsReport, receiptsParamsMap, receiptsDataSource);

JasperReport invoicesReport = JasperCompileManager.compileReport(srcInvoicesReport);
JasperPrint jpInvoicesReport = JasperFillManager.fillReport(invoicesReport, invoicesParamsMap, invoicesDataSource);

List<JasperPrint> printList = new ArrayList<JasperPrint>();

printList.add(jpOrdersReport);
printList.add(receiptsReport);
printList.add(invoicesReport);

JRExporter exporter = new JRPdfExporter();
exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, printList);

exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, output);
exporter.exportReport();