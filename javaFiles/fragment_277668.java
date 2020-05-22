public class DataBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // add more properties as necessary
    int id;
    String word;

    public DataBean(int id, String word) {
        setId(id);
        setWord(word);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
}