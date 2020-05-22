private static JasperDesign getPageTemplateDesign(String templatePath) throws JRException{

    logger.info("Setting format page desing for Template: " + templatePath);

    JasperDesign design = JRXmlLoader.load(templatePath);

    logger.info("Setting Page Dimessions Format to: " + pageFormat);
    if (JRDriver.pageFormat.equals("A4")) {
        JRDriver.pageWidth=595; 
        JRDriver.pageHeight=842;
        JRDriver.columnCount=1;
        JRDriver.columnWidth=555;
        JRDriver.columnSpacing=0;
        JRDriver.leftMargin=20;
        JRDriver.rightMargin=20;
        JRDriver.topMargin=20;
        JRDriver.bottomMargin=20;
    }
    else if (JRDriver.pageFormat.equals("LETTER")) {
        JRDriver.pageWidth=612; 
        JRDriver.pageHeight=792;
        JRDriver.columnCount=1;
        JRDriver.columnWidth=517;
        JRDriver.columnSpacing=0;
        JRDriver.leftMargin=20;
        JRDriver.rightMargin=20;
        JRDriver.topMargin=20;
        JRDriver.bottomMargin=20;
    }
    //Setting twmplate dimesions
    design.setPageWidth(JRDriver.pageWidth);
    design.setPageHeight(JRDriver.pageHeight);

    design.setColumnCount(JRDriver.columnCount);
    design.setColumnWidth(JRDriver.columnWidth);
    design.setColumnSpacing(JRDriver.columnSpacing);

    design.setLeftMargin(JRDriver.leftMargin);
    design.setRightMargin(JRDriver.rightMargin);
    design.setTopMargin(JRDriver.topMargin);
    design.setBottomMargin(JRDriver.bottomMargin);      

    return design;
}

private static void reformattingPageTemplate(String path) throws JRException{

    logger.info("Getting Design Template from: " + path);
    JasperDesign design= getPageTemplateDesign(path);

    String destFile=path.replaceAll("jrxml", "jasper");     
    logger.info("Compiling Re-formated Design Template to: " + destFile);
    JasperCompileManager.compileReportToFile(design, destFile); 
}

private static void formattingALLPage() throws JRException{

    reformattingPageTemplate(reportBookPagesDir + "/FrontCover.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/Copyright.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/TableOfContent.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/Summary.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/Content.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/AppendixWarnings.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/Index.jrxml");
    reformattingPageTemplate(reportBookPagesDir + "/BackCover.jrxml");
    //reformattingPageTemplate(reportTemplatePath);
}