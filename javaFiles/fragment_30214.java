class FastStringArrayContainsChar {
    private Map<Char, Set<String>> index = new HashMap<Char, Set<String>>();
    public FastStringArrayContainsChar(String[] input) {
        for (String s: input) {
            for (int i=0; i<s.length; s++) {
                char c = s.charAt(i);
                if (index.contains(c))
                    index.get(c).put(s);
                else
                    index.put(c, new HashSet<String>(){{this.put(s);}});
            }
        }
    }
    public List<String> containsChar(char c) {
        return new ArrayList<String>(index.get(c));
    }
}