Please go through bellow code :-

package com.test;


import com.lowagie.text.Rectangle;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
/**
*
* @author Jamsheer T
* +91 9846716175
*/
public class PDFConversion
{
/**
* This method is used to convert the given file to a PDF format
* @param inputFile - Name and the path of the file
* @param outputFile - Name and the path where the PDF file to be saved
* @param isPictureFile
*/
private void createPdf(String inputFile, String outputFile, boolean isPictureFile)
 {
  /**
  * Set the page size for the image
  */
 Rectangle pageSize = new Rectangle(2780, 2525);
 Document pdfDocument = new Document(pageSize);
 String pdfFilePath = outputFile;
 try
 {
     FileOutputStream fileOutputStream = new FileOutputStream(pdfFilePath);
     PdfWriter writer = null;
     writer = PdfWriter.getInstance(pdfDocument, fileOutputStream);
     writer.open();
     pdfDocument.open();
     /**
     * Proceed if the file given is a picture file
     */
      if (isPictureFile)
     {
      pdfDocument.add(com.lowagie.text.Image.getInstance(inputFile));
     }
     /**
     * Proceed if the file given is (.txt,.html,.doc etc)
     */
     else
     {
     File file = new File(inputFile);

     }

     pdfDocument.close();
     writer.close();
   }
   catch (Exception exception)
   {
     System.out.println("Document Exception!" + exception);
    }
  }

  public static void main(String args[])
  {
   PDFConversion pdfConversion = new PDFConversion();
   pdfConversion.createPdf("C:\\Users\\Jamsheer T\\Desktop\\test\\Lily flower   
  wallpaper.jpg", "C:\\Users\\Jamsheer T\\Desktop\\test\\myfile.pdf", true);

  }
  }