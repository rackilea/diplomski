final ObjectInputStream objectInputStream = new ObjectInputStream(
        new ByteArrayInputStream(
                byteArrayOutputStream.toByteArray()
        )
);
byte[] original = (byte[]) objectInputStream.readObject();