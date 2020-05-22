String text = "Until recently, increasing dividend yields grabbed the headlines. However, increasing\n" + 
        "yields were actually more a reflection of the market capitalisation challenge than of the\n" + 
        "fortunes of mining shareholders. The yields mask a complete u-turn from boom-time\n" + 
        "dividend policies. More companies have now announced clear percentages of profit\n" + 
        "distribution policies. The big story today is the abandonment of progressive dividends\n" + 
        "by the majors, confirming that no miner was immune from a sustained commodity\n" + 
        "cycle downturn, however diversified their portfolio. \n" +
        "\ngraph_add\n\n" +
        "Shareholders were not fully rewarded for the high commodity prices and huge\n" + 
        "profits experienced in the boom, as management ploughed cash and profits into\n" + 
        "bigger and more marginal assets. During those times, production was the main\n" + 
        "game and shareholders were rewarded through soaring stock prices. However,\n" + 
        "this investment proposition relied on prices remaining high. ";

final Image img;
try (InputStream imageResource = getClass().getResourceAsStream("Graph.png")) {
    ImageData data = ImageDataFactory.create(StreamUtil.inputStreamToArray(imageResource));
    img = new Image(data);
}

PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
PageSize ps = PageSize.A4;;
Document doc = new Document(pdfDoc, ps);

Rectangle effectivePageSize = doc.getPageEffectiveArea(ps);
img.scaleToFit(effectivePageSize.getWidth(), effectivePageSize.getHeight());
PdfFormXObject pdfFormXObject = new PdfFormXObject(new Rectangle(img.getImageScaledWidth(), img.getImageScaledHeight()));
PdfCanvas pdfCanvas = new PdfCanvas(pdfFormXObject, pdfDoc);
try (Canvas canvas = new Canvas(pdfCanvas, pdfDoc, pdfFormXObject.getBBox().toRectangle())) {
    canvas.add(img);
}

BufferedReader br = new BufferedReader(new StringReader(text));
String line;
while ((line = br.readLine()) != null) {
    if("graph_add".equals(line)) {
        doc.add(new Image(pdfFormXObject));
    } else {
        doc.add(new Paragraph(line));
    }
}
doc.close();