public class CollectorSO
{
    public static void main(String[] args)
    {
        Stream<Entry<String, Object>> stream = Stream.empty();
        Map<String, Object> map = stream.collect(entryToMapCollector());
    }

    private static <K, V> Collector<Entry<K, V>, ?, Map<K, V>> entryToMapCollector()
    {
        return Collectors.toMap(Entry::getKey, Entry::getValue);
    }
}