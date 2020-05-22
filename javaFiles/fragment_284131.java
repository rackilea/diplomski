Map<String, Integer> occurrencies = new HashMap<String, Integer>();
for (String word : list) {
    occurrencies.put(word, occurrencies.containsKey(word)
    ? occurrencies.get(word) + 1 : 1);
}
for (Entry<String, Integer> entry : occurrencies.entrySet()) {
    System.out.println("Word: "+entry.getKey()
                     + ", occurences: "+entry.getValue());
}