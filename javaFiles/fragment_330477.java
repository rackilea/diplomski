public T peek() {
    if (list.size() == 0)
        return null;
    T ret = list.get(head);
    head++;
    if (head == list.size()) {
        head = 0;
    }
    return ret;
}