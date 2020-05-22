package com.company.util;

import java.io.IOException;
import java.io.LineNumberReader;

public class LengthLimitedLineNumberReader {

  public static final int DEFAULT_MAX_LINE_LENGTH = 1024;
  private LineNumberReader delegate;
  private int readerMaxLineLen = DEFAULT_MAX_LINE_LENGTH;

  private int lineNumber = 0;

  public LengthLimitedLineNumberReader(LineNumberReader delegate) {
    this.delegate = delegate;
  }

  public LengthLimitedLineNumberReader(LineNumberReader delegate, int readerMaxLineLen) {
    this(delegate);
    this.readerMaxLineLen = readerMaxLineLen;
  }

  public int getLineNumber() {
    return lineNumber;
  }

  public String readLine() throws IOException {

    StringBuilder line = new StringBuilder();

    int c = delegate.read();
    if (c <= 0) {
      return null;
    }
    while (c >= 0 && c != '\n') {
      if (line.length() >= readerMaxLineLen) {
        throw new IOException("Exceeded max line length of " + readerMaxLineLen);
      }

      line.append((char) c);
      c = delegate.read();
    }

    lineNumber++;

    return line.toString();
  }

  public void close() throws IOException {
    delegate.close();
  }
}