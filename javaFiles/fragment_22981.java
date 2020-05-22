// step 1
Document document = new Document();
// step 2
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdf.pdf"));
// step 3
document.open();
// step 4
XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                new ByteArrayInputStream(views.html.index.render().body().getBytes()));

//step 5
document.close();

System.out.println( "PDF Created!" );