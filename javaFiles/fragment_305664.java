if (distinctWordCounts.hasKey(line)) {
  // We have seen this word. Increment the count we've seen it.
  distinctWordCounts.put(line, distinctWordCounts.get(line) + 1);
} else {
  // We have never seen this word. Set the count seen to 1.
  distinctWordCounts.put(line, 1);
}