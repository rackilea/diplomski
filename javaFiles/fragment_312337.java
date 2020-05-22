public void add(Comparable data) { //you can generify your code and then use Comparable<T>
        Node nodeToInsert = new Node(data);
        if (head == null) {
            head = nodeToInsert;

        }
        else if (data.compareTo(head.data) < 0) {
            nodeToInsert.next = head;
            head = nodeToInsert;
        }
        else {
            Node before = head, after = head.next;
            while (after != null) {
                if (data.compareTo(after.data) < 0) {
                    break;
                }
                before = after;
                after = after.next;
            }
            nodeToInsert.next = before.next;
            before.next = nodeToInsert;
        }
    }