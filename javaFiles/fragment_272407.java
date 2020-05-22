p.println("some string")
  +-> outputStreamWriter.write("some string")
      +--> write to internal buffer (as bytes)

p.flush();
  +-> outputStreamWriter.flush();
      +--> internal buffer flush
         +--> fileOutputStream.write(bytes)