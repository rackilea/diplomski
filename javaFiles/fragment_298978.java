while (contentItr.hasNext()) {
    String word = contentItr.next();
    if (wordIndex.containsKey(word)) {
        LinkedList<String> temp = w.get(word);
        temp.addLast(currentUrl);
    } else {
        LinkedList<String> temp = new LinkedList<String>();
        temp.add(currentUrl);
        w.put(word, temp);
    }
}