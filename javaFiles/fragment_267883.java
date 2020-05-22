for (Iterator<String> it = list1.iterator(); it.hasNext();) {
    String s = it.next();
    if (s.equals("World")) {
        it.remove();
    }
}