PQueueItem<T> prior = null;
    PQueueItem<T> current = head;

    // Walk to the insertion point:
    while (current != null) {
        int comparison = compare(data, priority, current);
        if (comparison >= 0) {
            if (comparison == 0) {
                return; // No insert?
            }
            break;
        }
        prior = current;
        current = current.getNext();
    }

    // Create the link:
    PQueueItem<T> newPQ = new PQueueItem<T>(data, priority);
    newPQ.setNext(current);

    if (prior == null) {
        head = newPQ;
    } else {
        prior.setNext(newPQ);
    }