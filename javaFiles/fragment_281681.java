public records load(File f) {
try {
    FileInputStream fis = new FileInputStream(f);
    ObjectInputStream ois = new ObjectInputStream(fis);

    records r1= (records) ois.readObject(); // THIS LINE GIVING ERROR

    ois.close();
    fis.close();
    return r1;
} catch (IOException e) {
    return null;
} catch (ClassNotFoundException e) {
    return null;
}
return null;

. . .