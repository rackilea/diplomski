public void addLast(I anItem) {
    Link<I> aLink = new Link<I>(anItem);
    if (isEmpty()) {
        first = aLink;
        first = last;
    } else {
        last.setAfter(aLink);
        aLink.setBefore(last);
        last = aLink;
    }
}