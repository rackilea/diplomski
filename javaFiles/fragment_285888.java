int[] charCount = new int[26];
char[] chars = foog.toLowerCase().toCharArray();

for (char c : chars) {
    charCount[c - 'a']++;
}

Arrays.sort(charCount);
int max = charCount[charCount.length - 1];