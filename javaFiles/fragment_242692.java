class SLList {

    public class IntNode {

        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

        private int theSize()
        {
            return size();
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public int size() {
        if (first.next == null) {
            return 1;
        }
        return 1 + first.next.theSize();
    }
}