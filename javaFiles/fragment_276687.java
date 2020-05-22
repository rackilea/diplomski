import java.io.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class CreatePDF{
    public static void main(String arg[])throws Exception{
      try{
                Document document=new Document();
                FileOutputStream fos=new FileOutputStream("C:/header-footer.pdf");
                PdfWriter writer = PdfWriter.getInstance(document, fos);
                document.open();
                Image image1 = Image.getInstance("C:/image1.jpg");
                Image image2 = Image.getInstance("C:/image2.jpg");

                image1.setAbsolutePosition(0, 0);
                image2.setAbsolutePosition(0, 0);

                PdfContentByte byte1 = writer.getDirectContent();
                PdfTemplate tp1 = byte1.createTemplate(600, 150);
                tp1.addImage(image2);

                PdfContentByte byte2 = writer.getDirectContent();
                PdfTemplate tp2 = byte2.createTemplate(600, 150);
                tp2.addImage(image1);

                byte1.addTemplate(tp1, 0, 715);
                byte2.addTemplate(tp2, 0, 0);

                Phrase phrase1 = new Phrase(byte1 + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));
                Phrase phrase2 = new Phrase(byte2 + "", FontFactory.getFont(FontFactory.TIMES_ROMAN, 7, Font.NORMAL));

                HeaderFooter header = new HeaderFooter(phrase1, true);
                HeaderFooter footer = new HeaderFooter(phrase2, true);
                document.setHeader(header);
                document.setFooter(footer);
                document.close();
                System.out.println("File is created successfully showing header and footer.");
                }
                catch (Exception ex){
                    System.out.println(ex);

                }
            }
        }