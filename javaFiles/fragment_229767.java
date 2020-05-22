public class DoubleNode extends LinkedList.Node implements DoublyLinkable<Integer, LinkedList.Linkable> {
    LinkedList.Linkable prev;

    public DoubleNode(int value) {
        super(value);
    }

    @Override
    public LinkedList.Linkable getPrev() {
        return prev;
    }

    @Override
    public void setPrev(LinkedList.Linkable prev) {
         this.prev = prev;
    }
}