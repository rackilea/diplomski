static class FlushedInputStream extends FilterInputStream { 

public FlushedInputStream(InputStream inputStream) {
    super(inputStream);
}

@Override
public long skip(long n) throws IOException { 

  long totalBytesSkipped = 0L;
  while (totalBytesSkipped < n) { 
    long bytesSkipped = in.skip(n - totalBytesSkipped);
    if (bytesSkipped == 0L) { 
      int byteReaded = read();
      if (byteReaded < 0) {
          break; 
      } else {
          bytesSkipped = 1;
      }
    }
    totalBytesSkipped += bytesSkipped;
  }
  return totalBytesSkipped;
}

}