public void saveThing(Serializable thing, String fileName) throws Exception {
    String tempFileName = fileName + "_tmp";
    File tempFile = new File(tempFileName);
    FileOutputStream fos = new FileOutputStream(tempFile);        
    FileDescriptor fd = fos.getFD();
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    oos.writeObject(thing);
    oos.flush();
    fd.sync();
    oos.close();
    f.renameTo(fileName);
}