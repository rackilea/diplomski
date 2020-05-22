// A naive binary serializer. 
  public byte[] serializeToBytes() {
      ByteArrayOutputStream bytes = new ByteArrayOutputStream(); 

      // Object name and number of attributes.
      // Write the 4 byte length of the string and the string itself to
      // the ByteArrayOutputStream.
      writeString("Person", bytes);
      bytes.write(2); // number of attributes;

      // Serialize age
      writeString("age", bytes);
      bytes.write(1); // type = 1 (i.e, int)
      writeString(Integer.toString(age), bytes);  

      // serialize name
      writeString("name", bytes);
      bytes.write(2); // type = 2 (i.e, string) 
      writeString(name, bytes);

      return bytes.toByteArray();
  }

  private static void writeString(String s, ByteArrayOutputStream bytes) {
      bytes.write(s.length());
      bytes.write(s.toBytes());
  }