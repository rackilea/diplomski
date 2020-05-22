public static byte[] getBytes(Serializable obj) throws IOException {
    ByteArrayOutputStream bos   = new ByteArrayOutputStream();
    ObjectOutputStream oos      = new ObjectOutputStream(bos);
    oos.writeObject(obj);

    byte[] data = bos.toByteArray();

    oos.close();
    return data;
}