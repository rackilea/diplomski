PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
Rectangle rect = new Rectangle(36, 700, 50, 50);
PdfFileSpec fs = PdfFileSpec.createEmbeddedFileSpec(pdfDoc, PATH, null, "test.docx", null, null, false);
PdfAnnotation attachment = new PdfFileAttachmentAnnotation(rect, fs)
        .setContents("Click me");

PdfFormXObject xObject = new PdfFormXObject(rect);
ImageData imageData = ImageDataFactory.create(IMG);
PdfCanvas canvas = new PdfCanvas(xObject, pdfDoc);
canvas.addImage(imageData, rect, true);
attachment.setNormalAppearance(xObject.getPdfObject());