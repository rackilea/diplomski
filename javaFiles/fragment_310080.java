TikaInputStream docxStream = TikaInputStream.get(new File("some-doc.docx"));
TikaInputStream pdfStream = TikaInputStream.get(new File("some-doc.pdf"));

ContentHandler handler = new DefaultContentHandler();
Metadata docxMeta = new Metadata();
Metadata pdfMeta = new Metadata();
ParseContext pc = new ParseContext();

Parser parser = TikaConfig.getDefaultConfig().getParser();

parser.parse(docxStream, handler, docxMeta, pc);
parser.parse(pdfStream, handler, pdfMeta, pc);

int docxParagraphCount = docxMeta.getInt(Office.PARAGRAPH_COUNT);
int pdfParagraphCount = pdfMeta.getInt(Office.PARAGRAPH_COUNT);