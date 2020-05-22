BaseFont unicode = BaseFont.createFont("/home/mani/Documents/Back up (works)/Devanagari/Devanagari.ttf", 
        BaseFont.COURIER,    BaseFont.EMBEDDED);
        Font font=new Font(unicode,12,Font.NORMAL,new BaseColor(50,205,50));

        table = new PdfPTable(new float[] { 10, 60, 30 });
        table.setWidthPercentage(100);
        PdfPCell customerLblCell = new PdfPCell(new Phrase("karent balance",
                font));