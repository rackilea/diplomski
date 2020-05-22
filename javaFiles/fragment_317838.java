private static ArrayList<Kanji> readFile() {
    ArrayList<Kanji> kanjis = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(
                "study_list_kanji.txt"));
        while (true) {
            try {
                try {
                    kanjis = ((ArrayList<Kanji>) in.readObject());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (EOFException e) {
                return kanjis;
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return kanjis;
}