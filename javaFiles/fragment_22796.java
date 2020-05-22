public int get(int pos)
{
    DNode current = new DNode();
    for(int i = 0; i <= pos && current != null; i++)
    {
        if(pos == 0){
            current = header;
        }
        else{
            current = current.next;
            // break; <-- remove this
        }
    }
    return current.element;
}