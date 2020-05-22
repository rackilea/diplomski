if(size == 0)
    {
        front = new ListNode(data,null);
        end = first; 
        size++;
    }
    else
    {
        ListNode <E> temp = new ListNode(data);
        end.setNext(temp);
        end = end.getNext();
        size++;
    }