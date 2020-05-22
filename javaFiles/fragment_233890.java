Map<String,Integer> map = new HashMap<String,Integer>();
for (int i = 0; i < patternsTest.length; i++) {
    String word=patternsTest[i];
    if (!map.containsKey(word)){
        map.put(word,1);
    } else {
        map.put(word, map.get(word) +1);
    }
}