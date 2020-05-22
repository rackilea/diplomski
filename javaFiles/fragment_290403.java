while (tmp != null && tmp.getVal() != v) {
    tmp = tmp.getNext();
}
if (tmp == null) {
    return;
}