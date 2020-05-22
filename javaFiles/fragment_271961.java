while (!lst.isEmpty()) {
    Iteartor<Integer> iterator = lst.listIterator();
    while (iterator.hasNext()) {
        Integer curInt = iterator.next();
        if (passTest(curInt)) {
            iterator.remove();
        }
    }
}