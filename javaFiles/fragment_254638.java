public void addToBack(rec) {
    if (first == null)
        first = new(rec)
    else
        addToBackInternal(first, rec)
}

private void addToBackInternal(curr, rec) {
    if (curr.next == null)
        curr.next = new(rec)
    else
        addToBackInternal(curr.next, rec)
}