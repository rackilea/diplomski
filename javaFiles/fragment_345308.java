public void serializeAndWriteToFile(Object o) {
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        FileUtils.writeByteArrayToFile(new File("D:\\Test.txt"), baos.toByteArray());
    } catch (IOException ioe) {
        // Handle exception
    }
}

public void readFromFileAndDeserialize() {
    try {
        ByteArrayInputStream bais = new ByteArrayInputStream(FileUtils.readFileoByteArray(new File("D:\\Test.txt")));
        ObjectInutStream ois = ne ObjectInutStream(bais);
        Object o = ois.readObject();
        // Type cast o to your object before using it
    } catch (IOException | ClassNotFoundException e) {
        // Handle exception
    }
}