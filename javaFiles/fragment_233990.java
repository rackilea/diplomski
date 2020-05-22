public void removeOddLength(Iterable<String> strings) {
    for (Iterator<String> it = strings.iterator(); it.hasNext(); ) {
        if (it.next().length() % 2 != 0) { 
            it.remove();
        }
    }
}