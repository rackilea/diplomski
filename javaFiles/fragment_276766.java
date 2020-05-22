import java.io.RandomAccessFile;
import java.io.File;

import java.lang.Math;

public class Example {
  protected static final int SKIP_N = 42;

  public static void main (String[] args)
    throws Exception
  {
    File fileHandle            = new File ("/tmp/sample_file");
    RandomAccessFile rafHandle = new RandomAccessFile (fileHandle, "r");
    String s1                  = new String ();

    long currentOffset = 0;
    long endOffset     = findEndOffset (SKIP_N, rafHandle);

    rafHandle.seek (0);

    while ((s1 = rafHandle.readLine ()) != null) {
      ;   currentOffset += s1.length () + 1; // (s1 + "\n").length
      if (currentOffset >= endOffset)
        break;

      System.out.println (s1);
    }
  }

  protected static long findEndOffset (int skipNLines, RandomAccessFile rafHandle)
    throws Exception
  {
    long currentOffset = rafHandle.length ();
    long endOffset     =  0;
    int  foundLines    =  0;

    byte [] buffer      = new byte[
      1024 > rafHandle.length () ? (int) rafHandle.length () : 1024
    ];

    while (foundLines < skipNLines && currentOffset != 0) {
      currentOffset = Math.max (currentOffset - buffer.length, 0);

      rafHandle.seek      (currentOffset);
      rafHandle.readFully (buffer);

      for (int i = buffer.length - 1; i > -1; --i) {
        if (buffer[i] == '\n') {
          ++foundLines;

          if (foundLines == skipNLines)
            endOffset = currentOffset + i - 1; // we want the end to be BEFORE the newline
        }
      }
    } 

    return endOffset;
  }
}