try {
    FileInputStream e = new FileInputStream("outings.ser");
    ObjectInputStream inputStream = new ObjectInputStream(e);
    return (ArrayList)inputStream.readObject();
} catch (ClassNotFoundException | IOException var3) {
    var3.printStackTrace();
}
return null;