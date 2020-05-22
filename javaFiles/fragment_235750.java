PdfDocument pdfDocument = new PdfDocument(new PdfWriter("C:/path/to.pdf"));
Document document = new Document(pdfDocument);

String text = "<p><strong>Jack </strong>and <strong>Jill </strong>went up the hill, then down the hill, around the hill then to <a href=\"#Chapter2\">Chapter 2</a>.</p>";

List<IElement> elements = HtmlConverter.convertToElements(text);

for (IElement element : elements) {
    if (element instanceof IBlockElement) {
        document.add((IBlockElement) element);
    }
}

document.add(new AreaBreak());

Text chapterTitle = new Text("Chapter 2 Jack").setDestination("Chapter2");
document.add(new Paragraph(chapterTitle));

document.close();