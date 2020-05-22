public class Word {
    private String word;

    public Word(String word) { this.word = word; }

    @Override
    public String toString() { return word; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word other = (Word) o;
        return Objects.equals(word, other.word);
    }

    @Override
    public int hashCode() { return Objects.hash(word); }
}