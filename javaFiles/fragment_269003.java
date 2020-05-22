if(head == null)
    {
        head = new CardInfoNode();
        head.setCardInfo(info);
        head.setNext(tail);
        tail.setPrev(node) // here lies the problem. tail must be set to something
                               // to make it doubly-linked. but tail is null since it's
                               // and end point of the list.
    }