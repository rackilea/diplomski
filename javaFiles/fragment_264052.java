public class ItemLinkedList {
    private ItemInfoNode head;
    private ItemInfoNode tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void addBack(ItemInfo info) {
        size++;
        if (head == null) {
            head = new ItemInfoNode(info, null, null);
            tail = head;
        } else {
            ItemInfoNode node = new ItemInfoNode(info, null, tail);
            this.tail.next =node;
            this.tail = node;
        }
    }

    public void addFront(ItemInfo info) {
        size++;
        if (head == null) {
            head = new ItemInfoNode(info, null, null);
            tail = head;
        } else {
            ItemInfoNode node = new ItemInfoNode(info, head, null);
            this.head.prev = node;
            this.head = node;
        }
    }

    public ItemInfo removeBack() {
        ItemInfo result = null;
        if (head != null) {
            size--;
            result = tail.info;
            if (tail.prev != null) {
                tail.prev.next = null;
                tail = tail.prev;
            } else {
                head = null;
                tail = null;
            }
        }
        return result;
    }

    public ItemInfo removeFront() {
        ItemInfo result = null;
        if (head != null) {
            size--;
            result = head.info;
            if (head.next != null) {
                head.next.prev = null;
                head = head.next;
            } else {
                head = null;
                tail = null;
            }
        }
        return result;
    }

    public class ItemInfoNode {

        private ItemInfoNode next;
        private ItemInfoNode prev;
        private ItemInfo info;

        public ItemInfoNode(ItemInfo info, ItemInfoNode next, ItemInfoNode prev) {
            this.info = info;
            this.next = next;
            this.prev = prev;
        }

        public void setInfo(ItemInfo info) {
            this.info = info;
        }

        public void setNext(ItemInfoNode node) {
            next = node;
        }

        public void setPrev(ItemInfoNode node) {
            prev = node;
        }

        public ItemInfo getInfo() {
            return info;
        }

        public ItemInfoNode getNext() {
            return next;
        }

        public ItemInfoNode getPrev() {
            return prev;
        }
    }
}