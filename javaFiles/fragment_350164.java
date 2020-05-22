public static String getMostFrequentSequence(final String input, final int patternLength) {
    final Multiset<String> multiset = HashMultiset.create();
    final int length = patternLength < 0 ? input.length() : Math.min(patternLength, input.length());
    for (int l = 2; l < length; l++) {
        for (int o = 0; o < input.length() - l; o++) {
            multiset.add(input.substring(o, o + l));
        }
    }
    return Ordering.from(new Comparator<Entry<String>>() {
        public int compare(final Entry<String> o1, final Entry<String> o2) {
            return
            ComparisonChain.start()
            .compare(o1.getCount(), o2.getCount())
            .compare(o1.getElement(), o2.getElement())
            .result();
        }
    }).max(multiset.entrySet()).getElement();
}