List<Object[]> list = ....
for (Iterator<Object[]> it = list.iterator(); it.hasNext();) {
    Object[] arr = it.next();
    for (Object o : arr) {
        ...
    }
}