import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.parser.PdfImageObject;
import com.itextpdf.text.pdf.PdfNumber;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.*;

public class PDFConverter{
    public static void main(String [] args){
        if(args.length==1){
            if(hasJpeg2000(args[0])){
                System.out.println("Contains JPEG2000 images: Converting them to JPEG..."); 
                convertPDF(args[0]);
                System.out.println("Done...");
            }else{
                System.out.println("Doesn't contain any JPEG2000 images: Nothing to be done...");   
            }
        }else{
            System.out.println("Please specify a PDF filename as a command line argument!");    
        }
    }
    public static boolean hasJpeg2000(String s){
        try{
            PdfReader reader = new PdfReader(s); 
            int n = reader.getXrefSize();
            PdfObject object; 
            PRStream stream; 
            for (int i = 0; i < n; i++) {
                object = reader.getPdfObject(i); 
                if (object == null || !object.isStream())continue; 
                stream = (PRStream)object; 
                PdfImageObject image = new PdfImageObject(stream);
                PdfName filter = (PdfName)image.get(PdfName.FILTER);
                if (PdfName.JPXDECODE.equals(filter)) {
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void convertPDF(String s){
        try{
            PdfReader reader = new PdfReader(s); 
            int n = reader.getXrefSize();
            PdfObject object; 
            PRStream stream; 
            for (int i = 0; i < n; i++) {
                object = reader.getPdfObject(i); 
                if (object == null || !object.isStream())continue; 
                stream = (PRStream)object; 
                PdfImageObject image = new PdfImageObject(stream);
                PdfName filter = (PdfName)image.get(PdfName.FILTER);
                if (PdfName.JPXDECODE.equals(filter)) {
                    BufferedImage bi = image.getBufferedImage(); 
                    if (bi == null) continue; 
                    int width = (int)(bi.getWidth());
                    int height = (int)(bi.getHeight());
                    ByteArrayOutputStream imgBytes = new ByteArrayOutputStream(); 
                    ImageIO.write(bi, "JPG", imgBytes); 
                    stream.clear(); 
                    stream.setData(imgBytes.toByteArray(),false, PRStream.NO_COMPRESSION); 
                    stream.put(PdfName.TYPE, PdfName.XOBJECT); 
                    stream.put(PdfName.SUBTYPE, PdfName.IMAGE); 
                    stream.put(new PdfName("foo"+Math.random()), new PdfName("bar"+Math.random())); 
                    stream.put(PdfName.FILTER, PdfName.DCTDECODE); 
                    stream.put(PdfName.WIDTH, new PdfNumber(width)); 
                    stream.put(PdfName.HEIGHT, new PdfNumber(height)); 
                    stream.put(PdfName.BITSPERCOMPONENT,new PdfNumber(8)); 
                    stream.put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                }
            }
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("out.pdf")); stamper.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}