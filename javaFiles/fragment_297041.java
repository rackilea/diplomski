ArrayList<String> list = new ArrayList<>();
//add sentences here
list.add("My first sentence sentence");
list.add("My second sentence1 sentence1");

ArrayList<String[]> list2 = new ArrayList<>();
for (String s : list) { list2.add(s.split(" "));};
for (String[] s : list2) {
    Map<String, Integer> wordCounts = new HashMap<String, Integer>();

    for (String word : s) {
        Integer count = wordCounts.get(word);
        if (count == null) {
            count = 0;
        }
        wordCounts.put(word, count + 1);
    }
    for (String key : wordCounts.keySet()) {
        System.out.println(key + ": " + wordCounts.get(key).toString());
}