public class CustomLinkedList<E> implements List<E> {

    private ListNode<E> header;

    public CustomLinkedList() {
        this.header = null;
    }

    @Override
    public int size() {
        int size = 0;
        for (E it : this)
            size++;
        return size;
    }

    @Override
    public boolean isEmpty() {
        return header == null;
    }

    @Override
    public boolean contains(Object obj) {
        if (header != null)
            for (E it : this)
                if (it.equals(obj))
                    return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ListNode<E> it = null;

            @Override
            public boolean hasNext() {
                if (it==null && header!=null)
                    return true;
                else if (it != null)
                    return it.getNextIndex() != null;
                else
                    return false;
            }

            @Override
            public E next() {
                if (it==null)
                    it = header;
                else
                  it = it.getNextIndex(); 
                return it.getValue();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Iterator is read-only");
            }
        };
    }

    @Override
    public boolean add(E e) {
        ListNode<E> temp = new ListNode<>();
        temp.setValue(e);
        if (header == null) {
            header = temp;
        } else {
            ListNode<E> it = header;
            while (it.getNextIndex() != null)
                it = it.getNextIndex();
            temp.setPrevIndex(it);
            it.setNextIndex(temp);
        }
        return true;
    }

}