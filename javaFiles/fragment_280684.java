public E dequeue() {
        if (this.tail == null)
            throw new IndexOutOfBoundsException();
        else {
            E data = this.tail.getData();
            Node<E> temp = this.tail;

            this.tail = temp.getPrev();
            if ( this.tail == null ) { // if that was last node
                this.head = null;
                return data;
            }
            this.tail.setNext(null);

            temp.setPrev(null);
            temp.setNext(null);

            this.size--;
            return data;
        }
    }