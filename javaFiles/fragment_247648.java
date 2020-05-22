PdfDocument pdfDocument = new PdfDocument(new PdfWriter(pdfDest));
    Document document = new Document(pdfDocument);

    ConverterProperties converterProperties = new ConverterProperties();
    converterProperties.setCssApplierFactory(new CustomCssApplierFactory());
    List<IElement> list = HtmlConverter.convertToElements(new FileInputStream(htmlSource), converterProperties);