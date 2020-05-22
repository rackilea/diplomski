public class EntryConverter implements Function<Map.Entry<String, Integer>, WordComparable> {

    public WordComparable apply(Map.Entry<String, Integer> entry) {
        return new WordComparable(entry.getKey(), entry.getValue());
    }

}