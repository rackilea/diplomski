public static ArrayList<Info> load() {//Change return type
    File f = new File("savefile.dat");
    try {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            ArrayList<Info> a = (ArrayList<Info>) ois.readObject();//get the object that is read
            return a;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Failed to load");
        }
        fis.close();
    } catch (IOException ioe) {
        System.out.println("Failed to load");
    }
    return null;
  }