int[] wordCounts = makeCounts(word);
int[] soupCounts = makeCounts(soup);
for (int i=0; i<wordCounts.length; ++i) {
    if (wordCounts[i] > soupCount[i]) return false;
}
return true;

int[] makeCounts(String s) {
    int[] result = new int[Character.MAX_VALUE + 1];
    for (int i=0; i<s.length(); ++i) ++result[s.charAt(i)];
    return result;
}