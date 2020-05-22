public static void main(String[] args)
  {
    String data = "99D5503012013165411";
    String dataOnlyHexChars = data.replaceAll("[^0-9a-fA-F]", ""); // not very cool
    byte bytes[] = hexStringToByteArray(dataOnlyHexChars);
    Checksum checksum = new CRC32();
    checksum.update(bytes, 0, bytes.length);
    long checksumValue = checksum.getValue();
    System.out.println("Result of CRC32 : " +Long.toHexString(checksumValue) + " !");
    // prints: Result of CRC32 : 9671cb4a !
  }

  // took from https://stackoverflow.com/a/140861/6749977 and changed a bit :
  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[(len + 1) / 2]; // changed
    for (int i = 0; i < len; i += 2) {
        if (len==i + 1) // changed
          data[i / 2] = (byte) Character.digit(s.charAt(i), 16);
        else
          data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                               + Character.digit(s.charAt(i+1), 16));
    }
    return data;
  }