public static void main(String[] args) {
        System.out.println("Starting");

        try {

            final W3CDom w3cDom = new W3CDom();
            final Document w3cDoc = w3cDom.fromJsoup(Jsoup.parse(readFile()));
            final OutputStream outStream = new FileOutputStream("test.pdf");

            final PdfRendererBuilder pdfBuilder = new PdfRendererBuilder();
            pdfBuilder.useFastMode();
            pdfBuilder.withW3cDocument(w3cDoc, "/");
            pdfBuilder.useFont(new File(main.class.getClassLoader().getResource("fonts/SourceSansPro-Regular.ttf").getFile()), "source-sans");
            pdfBuilder.toStream(outStream);

            pdfBuilder.run();
            outStream.close();

        } catch (Exception e) {
            System.out.println("PDF could not be created: " + e.getMessage());
        }

        System.out.println("Finish.");
    }