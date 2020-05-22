Collection<List<String>> groupAnagrams(List<String> words) {
    return words.stream().collect(groupingBy(w -> {
                char[] chars = w.toCharArray();
                Arrays.sort(chars);
                return new String(chars);
            })).values();
}