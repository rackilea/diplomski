private static String test(String input) {
    char[] chars = input.toCharArray();

    // Collect chars with count of occurrences
    Map<Character, AtomicInteger> charMap = new LinkedHashMap<>();
    for (Character c : chars) {
        AtomicInteger count = charMap.get(c);
        if (count == null)
            charMap.put(c, new AtomicInteger(1));
        else
            count.incrementAndGet();
    }

    // Sort char/count pairs by count (descending)
    @SuppressWarnings("unchecked")
    Entry<Character, AtomicInteger>[] charArr = charMap.entrySet().toArray(new Map.Entry[charMap.size()]);
    Arrays.sort(charArr, new Comparator<Entry<Character, AtomicInteger>>() {
        @Override
        public int compare(Entry<Character, AtomicInteger> e1, Entry<Character, AtomicInteger> e2) {
            return Integer.compare(e2.getValue().intValue(), e1.getValue().intValue()); // descending
        }
    });

    // Replace "count" with "rank" (this updates values in charMap)
    for (int i = 0; i < charArr.length; i++)
        charArr[i].getValue().set(i);

    // Generate result
    StringBuilder buf = new StringBuilder();
    for (Character c : chars) {
        int rank = charMap.get(c).intValue();
        while (rank-- > 0)
            buf.append('0');
        buf.append('1');
        buf.append('(').append(c).append(')'); // Remove?
    }
    return buf.toString();
}