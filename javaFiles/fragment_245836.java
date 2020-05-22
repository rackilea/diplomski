public class MyLinkedList<T1> {
    private MyLinkedListItem<T1> first = null;
    private MyLinkedListItem<T1> last = null;

    public MyLinkedList() {
    }

    public void add(T1 item) {
        MyLinkedListItem<T1> newItem = new MyLinkedListItem<T1>(item);
        if (first == null) {
            first = newItem;
        } else {
            last.setNext(newItem);
        }
        last = newItem;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        if(first != null) {
            MyLinkedListItem<T1> current = first;

            while(current.hasNext()) {
                buffer.append(current.toString());
                buffer.append(" -> ");
                current = current.getNext();
            }

            buffer.append(current.toString());
        }

        return buffer.toString();
    }

    private class MyLinkedListItem<T2> {
        private T2 data;
        private MyLinkedListItem<T2> next = null;

        public MyLinkedListItem(T2 data) {
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

        public MyLinkedListItem<T2> getNext() {
            return next;
        }

        public void setNext(MyLinkedListItem<T2> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}