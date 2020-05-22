public static void main(final String args[]) throws Exception {
    final int maxSize = 4;
    final LinkedHashMap<String, String> cache = new LinkedHashMap<String, String>() {
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > maxSize;
        }
    };

    cache.put("A", "A");
    System.out.println(cache);
    cache.put("B", "A");
    System.out.println(cache);
    cache.put("C", "A");
    System.out.println(cache);
    cache.put("D", "A");
    System.out.println(cache);
    cache.put("E", "A");
    System.out.println(cache);
    cache.put("F", "A");
    System.out.println(cache);
    cache.put("G", "A");
}