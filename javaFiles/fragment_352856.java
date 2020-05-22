try {
    File mapFile = new File(getDir("storage", MODE_PRIVATE), "hashmap");
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(mapFile));
    oos.writeObject(hashmap);
    oos.flush();
    oos.close();

    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(mapFile));
    HashMap map = (HashMap)ois.readObject();
} catch (Exception e) {
    // Handle exception here
}