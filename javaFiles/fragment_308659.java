private Node<E> removeFirstNode() {
        if (isEmpty()) return null;
        Node<E> answer = this.head;
        this.head = this.head.getNext();
        answer.next = null; // Set next ptr to null
        this.size--;
        if (this.size == 0) {
            this.tail = null;
        }
        return answer;
    }