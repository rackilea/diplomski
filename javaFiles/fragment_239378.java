class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<Integer, String> hmap = new HashMap<>();
        hmap.put(1, "to");
        hmap.put(2, "in");
        hmap.put(3, "at");
        hmap.put(4, "on");
        hmap.put(5, "under");

        try (XMLEncoder stream = new XMLEncoder(new BufferedOutputStream(System.out))) {
            stream.writeObject(hmap);
        }
    }
}