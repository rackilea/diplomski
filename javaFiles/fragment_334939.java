//parameter is Object, instead of Building
    public static void writeObjectToDisk(Object obj, String name) throws IOException {
        //Create file output stream
        FileOutputStream fileOutStr = new FileOutputStream(name);
        //Create object output stream and write object
        ObjectOutputStream objOutStr = new ObjectOutputStream(fileOutStr);
        objOutStr.writeObject(obj);
        //Close all streams
        objOutStr.close();
        fileOutStr.close();
        System.out.printf("Serialized data is saved in a file  - "+name);
    }

    public static Object objectLoader(String filename) throws IOException,
                                                      ClassNotFoundException{
        FileInputStream fileInStr = new FileInputStream(filename);
        ObjectInputStream objInStr = new ObjectInputStream(fileInStr);
        Object obj = (Object) objInStr.readObject();
        objInStr.close();
        fileInStr.close();

        return obj;
    }