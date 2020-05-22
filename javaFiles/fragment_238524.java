public static class Header extends PdfPageEventHelper {             
    public void onEndPage(PdfWriter writer, Document document) {
        try
        {
            PdfContentByte cb = writer.getDirectContent();      

            /*
              Some code to place some text in the header
            */

            Image imgSoc = Image.getInstance("C:\\...\\Logo.jpg");
            imgSoc.scaleToFit(110,110);
            imgSoc.setAbsolutePosition(390, 720);

            cb.addImage(imgSoc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}