DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));


public static void writeObject(DataOutputStream dos, Serializable obj) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(obj);
    oos.close();
    dos.writeUTF("OBJECT");
    byte[] bytes = baos.toByteArray();
    dos.writeInt(bytes.length);
    dos.write(bytes);
    dos.flush();
}

public static void writeBytes(DataOutputStream dos, byte[] bytes) {
    dos.writeUTF("BYTES");
    dos.writeInt(bytes.length);
    dos.write(bytes);
    dos.flush();
}

public static void writeText(DataOutputStream dos, String text) {
    dos.writeUTF("TEXT");
    dos.writeUTF(text);
    dos.flush();
}