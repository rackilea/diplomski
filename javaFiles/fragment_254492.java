public void readFromFile(String arg) throws Exception {
    try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(arg))) {
        System.out.println("Read from " + arg);
        readIn = (Cereal) ois.readObject();
        this.name = readIn.readBox();
    } catch (Exception e) {
        System.out.println("Had a problem");
        e.printStackTrace();
    }
}