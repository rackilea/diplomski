Map<String, String> wordIndex = new HashMap<String, String>();
Map<String, List<String>> w = new HashMap<String, List<String>>();

List<String> content = new ArrayList<String>();
Iterator<String> contentItr = content.iterator();

while (contentItr.hasNext()) {
    String word = contentItr.next();
    if (wordIndex.containsKey(word)) {
        List<String> temp = w.get(word);
        temp.add(currentUrl);
    } else {
        List<String> temp = new ArrayList<String>();
        temp.add(currentUrl);
        w.put(word, temp);
    }
}