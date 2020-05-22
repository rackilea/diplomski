// writing looks fine
public void write(String folder, ArrayList<POInode> POIlist) throws IOException {
    int nextFileItarator = (int) Files.list(Paths.get(folder)).count();
    nextFileItarator++;

    try (FileOutputStream fout = new FileOutputStream(folder + nextFileItarator + ".txt");
         ObjectOutputStream oos = new ObjectOutputStream(fout)) {

        oos.writeObject(POIlist);
    }
}

// I read the quantity OK, but empty or wrong values...
public ArrayList<POInode> load(String file) throws IOException {
    ArrayList<POInode> listOfLoadedPOIs = new ArrayList<POInode>();

    try (FileInputStream fin = new FileInputStream(file);
         ObjectInputStream ois = new ObjectInputStream(fin)) {

        // readObject() throws ClassnotFound or empty values.
        listOfLoadedPOIs = (ArrayList<POInode>) ois.readObject();
    }
    return (ArrayList<POInode>) listOfLoadedPOIs;
}