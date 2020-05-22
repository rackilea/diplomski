while (contentItr.hasNext()) {
    String word = (String) contentItr.next();
    if (wordIndex.containsKey(word)) {
        LinkedList temp = (LinkedList) w.get(word);
        temp.addLast(currentUrl);
    } else {
        LinkedList temp = new LinkedList();
        temp.add(currentUrl);
        w.put(word, temp);
    }
}