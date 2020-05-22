String documents=newJFileChooser().getFileSystemView().getDefaultDirectory().toString();

JasperCompileManager.compileReportToFile(jasperDesign,documents+"\\report1.jasper");

JasperPrint jasperPrint = JasperFillManager.fillReport(documents+"\\report1.jasper, null, conn);

JasperViewer.viewReport(jasperPrint,false);