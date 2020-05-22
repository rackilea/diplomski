buffer = new byte[1024];

try {
        is = getBaseContext().getAssets().open("xml/xml.xml");
    } catch (IOException e) {
        e.printStackTrace();
    }

    int count = 0, bytesRead = 0;;
    ByteArrayOutputStream bytestream = new ByteArrayOutputStream(1024 * 2);
    try {
          bytesRead = is.read(buffer);

          while(bytesRead != -1)
          {
            deobfuscate(buffer);
            bytestream.write(buffer, 0, bytesread);
            count += bytesRead;
            bytesRead = is.read(buffer);
          }
    } catch (IOException e) {
        e.printStackTrace();
    }
    String output = new String(bytestream.tobyteArray());