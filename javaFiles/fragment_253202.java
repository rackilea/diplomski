public class WordOccurrence implements Comparable<WordOccurrence> {

    private final String word;
    private int totalCount = 0;
    private Set<Integer> lineNumbers = new TreeSet<>();

    public WordOccurrence(String word, int firstLineNumber) {
        this.word = word;
        addOccurrence(firstLineNumber);
    }

    public final void addOccurrence(int lineNumber) {
        totalCount++;
        lineNumbers.add(lineNumber);
    }

    @Override
    public int compareTo(WordOccurrence o) {
        return totalCount - o.totalCount;
    }

    @Override
    public String toString() {
        StringBuilder lineNumberInfo = new StringBuilder("[");
        for (int line : lineNumbers) {
            if (lineNumberInfo.length() > 1) {
                lineNumberInfo.append(", ");
            }
            lineNumberInfo.append(line);
        }
        lineNumberInfo.append("]");
        return word + ", occurences: " + totalCount + ", on rows "
                + lineNumberInfo.toString();
    }
}