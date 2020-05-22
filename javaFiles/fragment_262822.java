PDDocument source = PDDocument.loadNonSeq(SOURCE, null);
List<PDPage> pages = source.getDocumentCatalog().getAllPages();

PDDocument target = new PDDocument();
PDPage page = new PDPage();
PDRectangle cropBox = page.findCropBox();
page.setResources(new PDResources());
target.addPage(page);

PDFormXObject xobject = importAsXObject(target, pages.get(0));
page.getResources().addXObject(xobject, "X");

PDPageContentStream content = new PDPageContentStream(target, page);
AffineTransform transform = new AffineTransform(0, 0.5, -0.5, 0, cropBox.getWidth(), 0);
content.drawXObject(xobject, transform);
transform = new AffineTransform(0.5, 0.5, -0.5, 0.5, 0.5 * cropBox.getWidth(), 0.2 * cropBox.getHeight());
content.drawXObject(xobject, transform);
content.close();

target.save(TARGET);
target.close();
source.close();