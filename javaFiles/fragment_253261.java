Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File(RESULT_FOLDER, "StaticFooterShort.pdf")));

String html = "<p>Short Test Footer.</p>";
Footer footer = new Footer(html, document.right() - document.left());
writer.setPageEvent(footer);
footer.setBottomMargin(document, 10, 10);

document.open();

for (int i = 0; i < 200; i++) {
    document.add(new Paragraph("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, ..."));
}

document.close();