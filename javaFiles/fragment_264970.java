public static Map<String,Integer> mostCommonSubstring(String s, int len) {
    int[] charHistogram = new int[Character.MAX_VALUE+1];
    s.chars().forEach(ch -> charHistogram[ch]++);
    int most = 0;
    HashMap<Buffer, Integer> subStrings = new HashMap<>();
    CharBuffer cb = CharBuffer.wrap(s);
    for(int ix = 0, e = s.length()-len; ix <= e; ix++) {
        if(charHistogram[s.charAt(ix)] < most) continue;
        int num = subStrings.merge(cb.limit(ix+len).position(ix), 1, Integer::sum);
        if(num == 1) cb = CharBuffer.wrap(s);
        if(num > most) most = num;
    }
    final int mostOccurences = most;
    return subStrings.entrySet().stream()
        .filter(e -> e.getValue() == mostOccurences)
        .collect(Collectors.toMap(e -> e.getKey().toString(), Map.Entry::getValue));
}