for (Iterator<Foo> iterator = arrayList.iterator(); iterator.hasNext(); ) {
    Foo c = iterator.next();
    if (...) {
        iterator.remove();
    }
}