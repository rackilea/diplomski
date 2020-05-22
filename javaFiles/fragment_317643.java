if (k == 0) {
        removedObject = this.removeFromFront();
    } else {

        ListNode prev = null;

        while (idx != k) {
            prev = removedNode;
            removedNode = removedNode.getNext();
            idx++;

            if (removedNode == null)
                throw new ListIndexOutOfBound();
        }

        if (removedNode == this.lastNode) {
            removedNode = (ListNode) this.removeFromBack();
        } else {
            removedObject = removedNode.data;
            prev.setNext(removedNode.getNext());
        }
    }