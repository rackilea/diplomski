public Node delete(Node p)
    {
        Node current; 
        Node previous =null;
        current = head.next;

        while (current.info != p.info && current.next != null)
        {
            previous = current;
            current = current.next;
        }

        if (current.info == p.info)
        {
            previous.next = current.next;
            //this previous here is what is giving me trouble
        }
        return current;
    }