public static boolean save(String key, Serializable obj) {
    try {
        FileOutputStream outStream = new FileOutputStream(instance.getCacheDir() + "/" + key);
        ObjectOutputStream objOutStream;
        objOutStream = new ObjectOutputStream(outStream);
        objOutStream.writeObject(obj);
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

    return true;
}


public static Object getObject(String key) {
    Object obj = null;
    if (!new File(instance.getCacheDir() + "/" + key).exists())
        return obj;
    FileInputStream inputStream;
    try {
        inputStream = new FileInputStream(instance.getCacheDir() + "/" + key);
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        obj = objInputStream.readObject();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return obj;
}