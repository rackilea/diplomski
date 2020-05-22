public static Set<DataPair> getAllWords(String[] tempsArray) {
    Set<DataPair> set = new HashSet<>();
    for (String row : tempsArray) {
        // PARSE YOUR STRING DATA
        // the way you were doing it seemed fine but something like this
        String[] rowArray = row.split(" ");
        String word = row[1];
        int id = Integer.parseInt(row[0]);
        DataPair pair = new DataPair(word, id);
        set.add(pair);
    }
    return set;
} 

class DataPair {
    private String word;
    private int id;

    public DataPair(String word, int id) {
        this.word = word;
        this.id = id;
    }

    public boolean equals(Object o) {
        if (o instanceof DataPair) {
            return ((DataPair) o).word.equals(word) && ((DataPair) o).id == id;
        }
        return false;
    }
}