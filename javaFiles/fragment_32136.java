String maxWord = null;
Integer maxCount = -1;
Map<String, Integer> wordCount = new HashMap<String, Integer>();
for (String str : getMyProgramOutput()) {
  if (!wordCount.containsKey(str)) { wordCount.put(str, 0); }
  int count = wordCount.get(str) + 1;
  if (count > maxCount) {
    maxWord = str;
    maxCount = count;
  }
  wordCount.put(str, count);
}