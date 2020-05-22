while(my.size() != 0)
    {
        temp.next = my.remove();
        temp = temp.next;
    }
    temp.next = null; // try adding this******