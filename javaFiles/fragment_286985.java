class ListNodes { 
    int item;
    ListNodes next;
}

int count(Node ptr_start)
{
    int c=0;
    Node ptr = new Node(); // IT CREATES A NEW NODE NAMED ptr.
    ptr = ptr_start; //ptr_start is a node which is coming from the other class name. and ptr is 
                     // has became same as ptr_start (the first node)
    while(ptr != null) // this loop will go as long as the ptr != null.
    {
        c++;
        ptr = ptr.next;   //ptr = ptr.next means ptr will become the next node in this line. 
    }

    return c; 
}