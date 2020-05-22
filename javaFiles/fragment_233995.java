for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
    String s =  iterator.next();
    if (s.length() % 2 == 0) {
        iterator.remove();
    }       
}