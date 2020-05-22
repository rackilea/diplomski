for (Iterator<List<Object>> iterator = list.iterator(); iterator.hasNext();) {
    List<Object> l = iterator.next();
    if (l.size() == 2) {
        nList.add((E) l);
        iterator.remove();
    }
}