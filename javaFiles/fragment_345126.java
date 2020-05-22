package so5997784;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.output.CountingOutputStream;

public class CountBytes {

  private static void dump(File outFile, Object... objs) throws IOException {
    FileOutputStream fos = new FileOutputStream(outFile);
    try {
      CountingOutputStream compressedCounter = new CountingOutputStream(fos);
      OutputStream gz = new GZIPOutputStream(compressedCounter);
      CountingOutputStream uncompressedCounter = new CountingOutputStream(gz);
      ObjectOutputStream oos = new ObjectOutputStream(uncompressedCounter);

      for (Object obj : objs) {
        oos.writeObject(obj);
        oos.flush();
        System.out.println(uncompressedCounter.getByteCount() + " -> " + compressedCounter.getByteCount());
      }
      oos.close();
      System.out.println(uncompressedCounter.getByteCount() + " -> " + compressedCounter.getByteCount());

    } finally {
      fos.close();
    }
  }

  public static void main(String[] args) throws IOException {
    File outFile = new File("objects.out.gz");
    dump(outFile, "a", "b", "cde", "hello", "world");
  }

}