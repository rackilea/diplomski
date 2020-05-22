public boolean containsAll(Collection<?> c) {
    Iterator<?> e = c.iterator();
    while (e.hasNext())
        if (!contains(e.next()))
            return false;
    return true;
}