public static void main(String[] args)
  {
    String data = "99D55030120131654101"; // notice the 01 at the end
    byte bytes[] = hexStringToByteArray(data);
    Checksum checksum = new CRC32();
    checksum.update(bytes, 0, bytes.length);
    long checksumValue = checksum.getValue();
    System.out.println("Result of CRC32 : " +Long.toHexString(checksumValue) + " !");
    // prints: Result of CRC32 : 9671cb4a !
  }

  // took from https://stackoverflow.com/a/140861/6749977 :
  public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] data = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
    return data;
  }