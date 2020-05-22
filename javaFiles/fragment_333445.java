public static void xhtmlToDocx1(String xhtml, String destinationPath, String fileName)
    {
        File dir = new File (destinationPath);
        File actualFile = new File (dir, fileName);

        WordprocessingMLPackage wordMLPackage = null;
        try
        {
            wordMLPackage = WordprocessingMLPackage.createPackage();
        }
        catch (InvalidFormatException e)
        {
            e.printStackTrace();
        }


        XHTMLImporterImpl XHTMLImporter = new XHTMLImporterImpl(wordMLPackage);

        OutputStream fos = null;
        try
        {
            fos = new ByteArrayOutputStream();

            System.out.println(XmlUtils.marshaltoString(wordMLPackage
                    .getMainDocumentPart().getJaxbElement(), true, true));

                        HTMLSettings htmlSettings = Docx4J.createHTMLSettings();
            htmlSettings.setWmlPackage(wordMLPackage);
  Docx4jProperties.setProperty("docx4j.Convert.Out.HTML.OutputMethodXML",
                    true);
            Docx4J.toHTML(htmlSettings, fos, Docx4J.FLAG_EXPORT_PREFER_XSL);
            wordMLPackage.save(actualFile); 
        }
        catch (Docx4JException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }