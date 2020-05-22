Document document=new Document();
try (FileOutputStream fos = new FileOutputStream(directory)) {
  PdfWriter.getInstance(document, fos);
  document.open();
  for(int i= 0; i< data.length;i++)
  {
    document.add(new Paragraph(data[i]));
    document.add(Chunk.NEWLINE);
  }
  //EDIT start
  document.close();
  //EDIT end
}