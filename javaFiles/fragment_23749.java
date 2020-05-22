public String get(int index)
    {
        assert( index >= 0 )
        Link current = this.first;
        while (index > 0) {
            index--;
            current = current.next;
            // Check to see if this is out of bounds of the links
            if (current == Null) {
                // Since you are returning a String, you can also return
                // some kind of a flag to say that the index is out of bounds
                return Null;
            }
        }
        return current.item;       
    }