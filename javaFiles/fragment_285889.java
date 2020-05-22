int[] charCount = new int[26];
char[] chars = foog.toLowerCase().toCharArray();

for (char c : chars) {
    charCount[c - 'a']++;
}

int max = Arrays.stream(charCount).max().getAsInt();