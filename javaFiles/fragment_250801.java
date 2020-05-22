protected void loadData() {
    // Gets/creates file object.
    saveFileObject = new File("savedata.ser");


    try {
        if (!saveFileObject.exists()) {
            saveFileObject.createNewFile();
        }
        // Create file input stream
        fileIn = new FileInputStream(saveFileObject);

        // Create object input stream
        inputStream = new ObjectInputStream(fileIn);

        // Try to deserialize
        parts = (ArrayList<Part>) inputStream.readObject();

        // close input stream
        inputStream.close();
    } catch (EOFException e) {
        System.out.println("EOFException thrown! Attempting to recover!");
    } catch (IOException e) {
        System.out.println("Uh oh...");
        e.printStackTrace();
    }
}