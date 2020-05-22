private  void deleteIfContains(LinkedList<String> list, String str) {
    Iterator<String> headIterator = list.iterator();
    HashMap<Integer, String> newValues = new HashMap<>();
    int index = 0;

    while (headIterator.hasNext()) {
        String headString = headIterator.next();

        if (headString.contains(str)) {
            headIterator.remove();
            //replace method won't handle ','..you will need to use regex for it
            newValues.put(index, headString.replace(str, ""));
        }
        index++;
    }

    //Avoid ConcurrentModificationException
    for (int i : newValues.keySet()) {
        list.add(i, newValues.get(i));
    }
}