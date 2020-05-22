String[] stringArray = {"x", "y", "z", "x", "x", "y", "a"};

final Map<String, Integer> counter = new HashMap<String, Integer>();
for (String str : stringArray)
    counter.put(str, 1 + (counter.containsKey(str) ? counter.get(str) : 0));

List<String> list = new ArrayList<String>(counter.keySet());
Collections.sort(list, new Comparator<String>() {
    @Override
    public int compare(String x, String y) {
        return counter.get(y) - counter.get(x);
    }
});