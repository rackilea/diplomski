import java.io.*;
import java.util.zip.*;
import java.nio.charset.*;

public class Zipper
{
  public static void main(String[] args)
  {    
    byte[] dataToCompress = "This is the test data."
      .getBytes(StandardCharsets.ISO_8859_1);

    try
    {
      ByteArrayOutputStream byteStream =
        new ByteArrayOutputStream(dataToCompress.length);
      try
      {
        GZIPOutputStream zipStream =
          new GZIPOutputStream(byteStream);
        try
        {
          zipStream.write(dataToCompress);
        }
        finally
        {
          zipStream.close();
        }
      }
      finally
      {
        byteStream.close();
      }

      byte[] compressedData = byteStream.toByteArray();

      FileOutputStream fileStream =
        new FileOutputStream("C:/Users/UserName/Desktop/zip_file.gz");
      try
      {
        fileStream.write(compressedData);
      }
      finally
      {
        try{ fileStream.close(); }
          catch(Exception e){ /* We should probably delete the file now? */ }
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
}