class SequenceListException extends Exception {

    SequenceListException() {
        super();
    }

    SequenceListException(String s) {
        super(s);
    }
}

public class SequenceList {

    /**
     * Member class Node encapsulates the nodes of the linked list in which the
     * stack is stored. Each node contains a data item and a reference to
     * another node - the next in the linked list.
     */
    protected class Node {

        public Node(Object o) {
            this(o, null, null);
        }

        public Node(Object o, Node p, Node n) {
            datum = o;
            prev = p;
            next = n;
        }
        // The Node data structure consists of three object references.
        // One for the datum contained in the node and two for 
        // the next and previous node in the list.
        protected Object datum;
        protected Node next;
        protected Node prev;
    }

    // We use object references to the head and tail of the list (the head
    // and tail of the sequence, respectively).
    private Node listHead;
    private Node listTail;

    // Only require a single constructor, which sets both object
    // references to null.
    /**
     * Constructs an empty sequence object.
     */
    public SequenceList() {
        listHead = null;
        listTail = null;
    }

    /**
     * Adds a new item at the start of the sequence.
     */
    public void insertFirst(Object o) {
        // There is a special case when the sequence is empty.
        // Then the both the head and tail pointers needs to be 
        // initialised to reference the new node.
        if (listHead == null) {
            listHead = new Node(o);
            listTail = listHead;
        } 
        // In the general case, we simply add a new node at the start
        // of the list via the head pointer.
        else {
            listHead.prev = new Node(o, null, listHead);
            listHead = listHead.prev;
        }
    }

    /**
     * Adds a new item at the end of the sequence.
     */
    public void insertLast(Object o) {
        // There is a special case when the sequence is empty.
        // Then the both the head and tail pointers needs to be 
        // initialised to reference the new node.
        if (listHead == null) {
            listHead = new Node(o);
            listTail = listHead;
        } 
        // In the general case, we simply add a new node to the end
        // of the list via the tail pointer.
        else {
            listTail.next = new Node(o, listTail, null);
            listTail = listTail.next;
        }
    }

    /**
     * Adds a new item at a specified position in the sequence.
     */
    public void insert(Object o, int index) throws SequenceListException {
        // Check the index is positive.
        if (index < 0) {
            throw new SequenceListException("Indexed Element out of Range");
        }

        // There is a special case when the sequence is empty.
        // Then the both the head and tail pointers needs to be 
        // initialised to reference the new node.
        if (listHead == null) {
            if (index == 0) {
                listHead = new Node(o);
                listTail = listHead;
            } else {
                throw new SequenceListException("Indexed element is out of range");
            }
            return;
        }

        // There is another special case for insertion at the head of
        // the sequence.
        if (index == 0) {
            insertFirst(o);
            return;
        } 

        // In the general case, we need to chain down the linked list
        // from the head until we find the location for the new
        // list node. If we reach the end of the list before finding
        // the specified location, we know that the given index was out
        // of range and throw an exception.
        Node nodePointer = listHead;
        int i = 1;
        while (i < index) {
            nodePointer = nodePointer.next;
            i += 1;
            if (nodePointer == null) {
                throw new SequenceListException("Indexed Element out of Range");
            }
        }

        // Now we've found the node before the position of the
        // new one, so we 'hook in' the new Node.
        Node newNode = new Node(o, nodePointer, nodePointer.next);
        if (nodePointer.next != null) {
            nodePointer.next.prev = newNode;
        }
        nodePointer.next = newNode;

        // Finally we need to check that the tail pointer is
        // correct. Another special case occurs if the new
        // node was inserted at the end, in which case, we need
        // to update the tail pointer.
        if (nodePointer == listTail) {
            listTail = newNode;
        }
    }

    /**
     * Removes the item at the start of the sequence.
     */
    public void deleteFirst() throws SequenceListException {
        // Check there is something in the sequence to delete.
        if (listHead == null) {
            throw new SequenceListException("Sequence Underflow");
        }

        // There is a special case when there is just one item in the
        // sequence. Both pointers then need to be reset to null.
        if (listHead.next == null) {
            listHead = null;
            listTail = null;
            return;
        }

        // In the general case, we just unlink the first node of the
        // list.
        listHead = listHead.next;
        listHead.prev = null;
    }

    /**
     * Removes the item at the end of the sequence.
     */
    public void deleteLast() throws SequenceListException {
        // Check there is something in the sequence to delete.
        if (listHead == null) {
            throw new SequenceListException("Sequence Underflow");
        }

        // There is a special case when there is just one item in the
        // sequence. Both pointers then need to be reset to null.
        if (listHead.next == null) {
            listHead = null;
            listTail = null;
            return;
        }

        // In the general case, we just unlink the last node of the
        // list.
        listTail = listTail.prev;
        listTail.next = null;
    }

    /**
     * Removes the item at the specified position in the sequence.
     */
    public void delete(int index) throws SequenceListException {
        // Check there is something in the sequence to delete.
        if (listHead == null) {
            throw new SequenceListException("Sequence Underflow");
        }

        // Check the index is positive.
        if (index < 0) {
            throw new SequenceListException("Indexed Element out of Range");
        }

        // There is a special case when there is just one item in the
        // sequence. Both pointers then need to be reset to null.
        if (listHead.next == null) {
            if (index == 0) {
                listHead = null;
                listTail = null;
            } else {
                throw new SequenceListException("Indexed element is out of range.");
            }
            return;
        } 

        // There is also a special case when the first element has to
        // be removed.
        if (index == 0) {
            deleteFirst();
            return;
        } 

        // In the general case, we need to chain down the list to find
        // the node in the indexed position.
        Node nodePointer = listHead;
        int i = 1;
        while (i < index) {
            nodePointer = nodePointer.next;
            i += 1;
            if (nodePointer.next == null) {
                throw new SequenceListException("Indexed Element out of Range");
            }

        }

        // Unlink the node and reset the tail pointer if that
        // node was the last one.
        if (nodePointer.next == listTail) {
            listTail = nodePointer;
        }
        // Change reference of node after the node which is removed.
        if (nodePointer.next.next != null) {
            nodePointer.next.next.prev = nodePointer;
        }
        // Change reference of node before the node which is removed.
        nodePointer.next = nodePointer.next.next;
    }

    /**
     * Returns the item at the start of the sequence.
     */
    public Object first() throws SequenceListException {
        if (listHead != null) {
            return listHead.datum;
        } else {
            throw new SequenceListException("Indexed Element out of Range");
        }
    }

    /**
     * Returns the item at the end of the sequence.
     */
    public Object last() throws SequenceListException {
        if (listTail != null) {
            return listTail.datum;
        } else {
            throw new SequenceListException("Indexed Element out of Range");
        }
    }

    /**
     * Returns the item at the specified position in the sequence.
     */
    public Object element(int index) throws SequenceListException {
        // Check the index is positive.
        if (index < 0) {
            throw new SequenceListException("Indexed Element out of Range");
        }

        // We need to chain down the list until we reach the indexed
        // position
        Node nodePointer = listHead;
        int i = 0;
        while (i < index) {
            if (nodePointer.next == null) {
                throw new SequenceListException("Indexed Element out of Range");
            } else {
                nodePointer = nodePointer.next;
                i += 1;
            }
        }

        return nodePointer.datum;
    }

    /**
     * Tests whether there are any items in the sequence.
     */
    public boolean empty() {
        return (listHead == null);
    }

    /**
     * Returns the number of items in the sequence.
     */
    public int size() {
        //Chain down the list counting the elements

        Node nodePointer = listHead;
        int size = 0;
        while (nodePointer != null) {
            size += 1;
            nodePointer = nodePointer.next;
        }
        return size;
    }

    /**
     * Empties the sequence.
     */
    public void clear() {
        listHead = null;
        listTail = null;
    }

    public Node lastNode() {
        return listTail;
    }

    public Node firstNode() {
        return listHead;
    }
}