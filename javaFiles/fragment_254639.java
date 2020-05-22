public void addToBack(rec) {
    if (first == null)
        first = new(rec)
    else
        findLast(first).next = new(rec)
}

private Node findLast(curr) {
    if (curr.next == null)
        return curr
    return findLast(curr.next)
}