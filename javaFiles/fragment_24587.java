import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class TestFile {

  static final int IN_BUFFER_SIZE = 1024 * 8;
  static final int OUT_BUFFER_SIZE = 1024 *9; // make the out-buffer > in-buffer, i am lazy and don't want to check for overruns
  static final int MIN_READ_BYTES = 8;
  static final int MIN_WRITE_BYTES = 8;

  private File readFromFile1(File inFile) {

    final File outFile = new File("file2.txt");

    final ByteBuffer inBuffer = ByteBuffer.allocate(IN_BUFFER_SIZE);
    final ByteBuffer outBuffer = ByteBuffer.allocate(OUT_BUFFER_SIZE);

    FileChannel readChannel = null;
    FileChannel writeChannel = null;
    try {
      // open a file channel for reading and writing
      readChannel = FileChannel.open(inFile.toPath(), StandardOpenOption.READ);
      writeChannel = FileChannel.open(outFile.toPath(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

      long totalReadByteCount = 0L;
      long totalWriteByteCount = 0L;

      boolean readMore = true;
      while (readMore) {

        // read some bytes into the in-buffer
        int readOp = 0;
        while ((readOp = readChannel.read(inBuffer)) != -1) {
          totalReadByteCount += readOp;
        } // while

        // prepare the in-buffer to be consumed
        inBuffer.flip();

        // check if there where errors
        if (readOp == -1) {
          // end of file reached, read no more
          readMore = false;
        } // if

        // now consume the in-buffer until there are at least MIN_READ_BYTES in the buffer
        while (inBuffer.remaining() >= MIN_READ_BYTES) {
          // add data to the write buffer
          outBuffer.putLong(someOperation(inBuffer));
        } // while

        // compact the in-buffer and prepare for the next read, if we need to read more.
        // that way the possible remaining bytes of the in-buffer can be consumed after leaving the loop
        if (readMore) inBuffer.compact();

        // prepare the out-buffer to be consumed
        outBuffer.flip();

        // write the out-buffer until the buffer is empty
        while (outBuffer.hasRemaining())
          totalWriteByteCount += writeChannel.write(outBuffer);

        // prepare the out-buffer for writing again
        outBuffer.flip();
      } // while

      // error handling
      if (inBuffer.hasRemaining()) {
        System.err.println("Truncated data! Not a long value! bytes remaining: " + inBuffer.remaining());
      } // if

      System.out.println("read total: " + totalReadByteCount + " bytes.");
      System.out.println("write total: " + totalWriteByteCount + " bytes.");

    } catch (IOException e) {
      System.out.println("Some error occurred while reading from File: " + e);
    } finally {
      if (readChannel != null) {
        try {
          readChannel.close();
        } catch (IOException e) {
          System.out.println("Could not close read channel: " + e);
        } // catch
      } // if

      if (writeChannel != null) {
        try {
          writeChannel.close();
        } catch (IOException e) {
          System.out.println("Could not close write channel: " + e);
        } // catch
      } // if
    } // finally

    return outFile;
  }

  private long someOperation(ByteBuffer bb) {
    // consume the buffer, do whatever you want with the buffer.
    return bb.getLong(); // consumes 8 bytes of the buffer.
  }


  public static void main(String[] args) {
    TestFile testFile = new TestFile();
    File source = new File("input.txt");
    testFile.readFromFile1(source);
  }

}