Document document=new Document();
PdfWriter.getInstance(document, new FileOutputStream(directory));
document.open();
for(int i= 0; i< data.length;i++)
{
  document.add(new Paragraph(data[i]));
  document.add(Chunk.NEWLINE);
}
document.close();