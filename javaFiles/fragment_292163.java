ByteArrayOutputStream baos = new ByteArrayOutputStream();

Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, baos);
document.open();
XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("/html/loremipsum.html"));
document.close();

ByteArrayInputStream pdfInputStream = new ByteArrayInputStream(baos.toByteArray());