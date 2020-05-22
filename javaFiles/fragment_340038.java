import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

/**
 * Demonstrates weird issue when writing (appending) to a file over TsClient (Microsoft Remote Desktop).
 *
 * @author Martin
 */
public class WriteOverTsClientDemo
{
   // private static final File FILE_TO_WRITE = new File("\\\\tsclient\\C\\Temp\\TestFile.txt");
   private static final File FILE_TO_WRITE = new File("/tmp/TestFile.txt");

   private static final String ROW_DATA = "111111111122222222223333333333444444444555555555566666666667777777777888888888899999999990000000000";

   public static void main(final String[] args) throws IOException
   {
      if (!FILE_TO_WRITE.getParentFile().exists())
      {
         throw new RuntimeException("\nPlease create directory C:\\Temp\\ on your local machine and run this application via RemoteDesktop with C:\\ as a 'Local resource'.");
      }
      FILE_TO_WRITE.delete();
      new WriteOverTsClientDemo().execute();
   }

   private void execute() throws IOException
   {
      System.out.println("Writing to file: " + FILE_TO_WRITE);
      System.out.println();

      for (int i = 1; i <= 20; i++)
      {
         System.out.println("Writing batch " + i + "...");
         writeDataToFile(i);
         System.out.println("Size of file after batch " + i + ": " + FILE_TO_WRITE.length());
         System.out.println();
      }
      System.out.println("Done!");
   }

   private void writeDataToFile(final int batch) throws IOException
   {
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_TO_WRITE, batch > 1)))
      {
         writeData(batch, writer);
      }
   }

   private void writeData(final int batch, final BufferedWriter writer) throws IOException
   {
      for (final String data : createData())
      {
         writer.append(Integer.toString(batch));
         writer.append(" ");
         writer.append(data);
         writer.append("\n");
      }
   }

   private Iterable<String> createData()
   {
      return Collections.nCopies(100, ROW_DATA);
   }

}