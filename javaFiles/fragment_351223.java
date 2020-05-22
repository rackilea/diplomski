File saveFile = new File("filename.sav");
try {
    FileOutputStream fileOut = new FileOutputStream(saveFile);
    try (ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
        objOut.writeObject(number); // you should use lower case for variable names
        objOut.writeObject(array);
    }
} catch (IOException e) {
}