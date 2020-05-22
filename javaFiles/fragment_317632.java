public void add(String sortedWord, String word) {

    lock.read();

    if (head == null) {
        lock.upgrade();
        head = new TreeNode(sortedWord, word);
        lock.downgrade();
        lock.unlock();
        return;
    }

    TreeNode current = head, previous = null;
    while (current != null) {

            if (current.getSortedWord().equals(sortedWord)) {
                    lock.upgrade();
                    current.add(word);
                    lock.downgrade();
                    lock.unlock();
                    return;
            }

            .. more tree traversal, do not touch the lock here ..
            ...

    }

    if (previous.compareTo(sortedWord) > 0) {
        lock.upgrade();
        previous.setLeft(sortedWord, word);
        lock.downgrade();
    }
    else {
        lock.upgrade();
        previous.setRight(sortedWord, word);
        lock.downgrade();
    }

    lock.unlock();
}