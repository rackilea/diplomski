public class Driver {

    public static LinkedList getList() {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {

        LinkedList list = getList();

        LinkedList.Linkable head = list.getHead();
        LinkedList.Linkable beforeMiddle = null;
        LinkedList.Linkable middle = list.getHead();
        LinkedList.Linkable end = list.getHead();

        if (head != null) {
            // find the middle of the list
            while (true) {
                if (end.getNext() == null || end.getNext().getNext() == null) break;

                beforeMiddle = middle;
                middle = middle.getNext();

                end = end.getNext().getNext();
            }

            // Replace middle by reassigning the pointer to it
            if (beforeMiddle != null) {

                DoubleNode n = new DoubleNode((int) middle.getValue()); // same value
                n.setPrev(list.getHead()); // point back to the front
                n.setNext(middle.getNext()); // point forward to original value

                beforeMiddle.setNext((DoublyLinkable) n);
                middle = beforeMiddle.getNext();
            }

            // Build the "expected" output
            StringBuilder sb = new StringBuilder();
            final String DELIMITER = ", ";
            head = list.getHead();
            boolean atMiddle = false;
            if (head != null) {
                do {
                    if (head instanceof DoublyLinkable) {
                        atMiddle = true;
                        String out = String.format("Middle: %d, Prev: %d, ", (int) head.getValue(), (int) ((DoublyLinkable) head).getPrev().getValue());
                        sb.append(out);
                    } else {
                        if (atMiddle) {
                            sb.append("Next: ");
                            atMiddle = false;
                        }
                        sb.append(head.getValue()).append(DELIMITER);
                    }

                    head = head.getNext();
                } while (head != null);
            }
            sb.setLength(sb.length() - DELIMITER.length());

            System.out.println(sb.toString());
        }

    }
}