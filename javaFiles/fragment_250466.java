DefaultHttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
    HttpHeaders.setTransferEncodingChunked(response);
    response.headers().set(CONTENT_TYPE, "application/octet-stream");
    ctx.write(response);
    InputStream is = new InputStream() {
      int offset = -1;
      byte[] buffer = null;


      @Override
      public int read() throws IOException {
          if (offset == -1 || (buffer != null && offset == buffer.length)) {
            fillBuffer();
          }
          if (buffer == null || offset == -1) {
            return -1;
          }
          while (offset < buffer.length) {
            int b = buffer[offset];
            offset++;
            return b;
          }
          return -1;
      }

      // this method simulates an application that would write to
      // the buffer.

      // ONE GB (max size for the test;
      int sz = 1024 * 1024 * 1024; 

      private void fillBuffer() {
        offset = 0;
        if (sz <= 0) { // LIMIT TO ONE GB
            buffer = null;
            return;
        }
        buffer = new byte[1024];
        System.arraycopy(CONTENT_1KB_ZEROED, 0,
                buffer, 0,
                CONTENT_1KB_ZEROED.length);
        sz -= 1024;
      }
};


ctx.write(new ChunkedStream(new BufferedInputStream(is), 8192));
ctx.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT).addListener(ChannelFutureListener.CLOSE);