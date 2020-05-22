foreach result in query
{
    float[] colsWidth = { 4f, 9f, 5f, 8f };
    PdfPTable Content = new PdfPTable(colsWidth);//create content table
    //fill content
    content.keepRowsTogether(0);
    PdfPCell ContentCell = new PdfPCell();
   ContentCell .setNoWrap(false);
    ContentCell.addElement(Content);
    Master.addCell(ContentCell);//add header in master
}