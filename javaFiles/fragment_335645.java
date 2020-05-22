private static HashMap<Integer, Item> readItems() {
    HashMap<Integer, Item> items = null;
    try {
        FileInputStream fin = new FileInputStream("c:\\prespres.txt");
        ObjectInputStream ois = new ObjectInputStream(fin);
        items = (HashMap<Integer, Item>) ois.readObject();
        ois.close();
    } catch (Exception ex) {}
    return (items == null) ? new HashMap<>() : items;
}