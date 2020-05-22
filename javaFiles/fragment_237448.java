package pedrojoaquim;

import escpos.EscPos;
import escpos.image.BitonalThreshold;
import escpos.image.EscPosImage;
import escpos.image.RasterBitImageWrapper;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class PedroJoaquim {

    public void printImage() throws PrintException, IOException{
        String text_to_print = "Hello world!";
        PrintService foundService = PrintServiceLookup.lookupDefaultPrintService();
        DocPrintJob dpj = foundService.createPrintJob();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        /// your legacy commands ini
        // initialize printer
        outputStream.write(27); // ESC
        outputStream.write('@');

        // print text
        outputStream.write(text_to_print.getBytes());

        // feed 5 lines
        outputStream.write(27); // ESC
        outputStream.write('d');
        outputStream.write(5);

        // cut paper
        outputStream.write(29); // GS
        outputStream.write('V');
        outputStream.write(48);

        /// your legacy commands end

        /// fitting lib calls on same outputStream
        EscPos escpos = new EscPos(outputStream);

        RasterBitImageWrapper imageWrapper = new RasterBitImageWrapper();
        BufferedImage  githubBufferedImage = ImageIO.read(new File("/Users/marco/Downloads/smile.jpg"));
        EscPosImage escposImage = new EscPosImage(githubBufferedImage, new BitonalThreshold()); 
        // print smile image...
        escpos.write(imageWrapper, escposImage);        
        // lib end
        /// legacy continues from this point

        // print text
        outputStream.write(" Joaquim's Smile image".getBytes());

        // feed 5 lines
        outputStream.write(27); // ESC
        outputStream.write('d');
        outputStream.write(5);

        // cut
        outputStream.write(29); // GS
        outputStream.write('V');
        outputStream.write(48);


        // do not forguet to close outputstream
        outputStream.close();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());


        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc doc = new SimpleDoc(inputStream, flavor, null);
        dpj.print(doc, null);


    }

    public static void main(String[] args) throws IOException {
        PedroJoaquim obj = new PedroJoaquim();
        try {
            obj.printImage();
        } catch (PrintException ex) {
            Logger.getLogger(PedroJoaquim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}