public int count(int item) {
    int count = 0;
    Node current = first.getNext();
    while (current != null)
    {
        if (current.getInfo()==item) {
          count++;
        }
        current = current.getNext();
    }
    return count;
}