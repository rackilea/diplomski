@Test
    public void createPdfFromZip() throws Exception {
        String fileBundleZipFile = "sample.zip";
        String templateFileName = "index";
        String fileExt = ".html";
        ClassPathResource resourceZip = new ClassPathResource(fileBundleZipFile);
        ZipFile zipFile = new ZipFile(new File(this.getClass().getResource("/" + fileBundleZipFile).getFile()));
        ZipInputStream zipInputStream = new ZipInputStream(resourceZip.getInputStream());
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            if (zipEntry.getName().equals(templateFileName + fileExt)) {
                TemplateResolver resolver = new TemplateResolver();
                resolver.setTemplateMode("XHTML");
                resolver.setSuffix(fileExt);
                resolver.setResourceResolver(new CustomTemplateResolver(templateFileName, zipFile.getInputStream(zipEntry)));
                MyPojo data= getData();
                TemplateEngine engine = new TemplateEngine();
                engine.setTemplateResolver(resolver);
                Context context = new Context(Locale.US);
                context.setVariable("data", data);
                String dataHTMLString = engine.process(templateFileName, context);
                Path tempFile = Files.createTempFile("unzipped-data-html", ".pdf");
                createDataPdfWithCss(tempFile, dataHTMLString);
            }
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
    }