Document document = new Document();
File f= new File("C:\\delete.pdf");  //for instance
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(f));
document.open();
document.add(page);
document.close();
long filesize = f.length();   //this is the filesize in byte
f.delete();