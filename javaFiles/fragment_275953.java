public class Main implements Iterable<String>
{
    private final Map<String, String> myMap = new HashMap<>();
    {
        myMap.put("hello", "world");
        myMap.put("aaa", "bbb");
    }

    @Override
    public Iterator<String> iterator()
    {
        return Collections.unmodifiableMap(myMap).values().iterator();
    }
}