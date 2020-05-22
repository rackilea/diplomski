Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
document.open();
String foobar = "Foobar Film Festival";
...
Font times = new Font(bf_times, 12);
...
PdfContentByte canvas = writer.getDirectContent();
...
Phrase phrase = new Phrase(foobar, times);
ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 200, 572, 0);
ColumnText.showTextAligned(canvas, Element.ALIGN_RIGHT, phrase, 200, 536, 0);
ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 500, 0);
ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 464, 30);
ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, phrase, 200, 428, -30);
document.close();