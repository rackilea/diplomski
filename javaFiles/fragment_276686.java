//using iText 5.5.0 and XMLWorker 5.5.0

@FXML
private HTMLEditor htmlEditor;

@FXML
private void handleButtonAction(ActionEvent event) {
    final Document document = new Document();

    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test/loremipsum.pdf"));

    document.open();

    String htmlString = htmlEditor.getHtmlText();

    htmlString = htmlString.replace("<br>", "");
    htmlString = htmlString.replace("<br/>", "");
    htmlString = htmlString.replace("<br />", "");

    htmlString = htmlString.replace("<hr>", "<p></p>");
    htmlString = htmlString.replace("<hr/>", "<p></p>");
    htmlString = htmlString.replace("<hr />", "<p></p>");

    StringReader in = new StringReader(htmlString);

    try {
        final Paragraph test = new Paragraph();
        XMLWorkerHelper.getInstance().parseXHtml(new ElementHandler() {
            @Override
            public void add(final Writable w) {
                if (w instanceof WritableElement) {
                    List<Element> elements = ((WritableElement) w).elements();
                    for (Element e : elements) {
                        test.add(e);
                    }
                }
            }
        }, in);

        document.add(test);
    } catch (IOException | DocumentException e) {
        System.out.println(e.toString());
        System.out.println(e.getMessage());
    }

    document.close();
}