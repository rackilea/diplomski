public int get(int index) throws IndexOutOfBoundsException
    {
        Node reference = head;
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        for (int i = 0; i != index; i++)
            {
                reference.getNext(); // <--- the mistake is here
            }
        return reference.getElement();
    }