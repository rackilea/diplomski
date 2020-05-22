class TrieNode {
  boolean word;
  Map<Character, TrieNode> children = new HashMap<>();

  void add(String s, int i) {
    if (i == s.length()) {
      word = true;
    } else {
      children.computeIfAbsent(s.charAt(i), k -> new TrieNode()).add(s, i + 1);
    }
  }
}