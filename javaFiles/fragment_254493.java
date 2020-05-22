public void writeToFile(String arg) throws Exception {
    try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arg))) {
        writeOut = new Cereal(name, prize.describe());
        oos.writeObject(writeOut);
        System.out.println("wrote to " + arg);
    } catch (Exception e) {
        System.out.println("Problem");
        e.printStackTrace();
    }
}