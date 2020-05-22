int maxFreq = 0;
Character maxFreqChar = null;
for ( Map.Entry<Character, Integer> entry : a.entrySet() ) {
    int value = entry.getValue();
    if (value > maxFreq) {
        maxFreq = value;
        maxFreqChar = entry.getKey();
    }
}
System.out.println(maxFreqChar);