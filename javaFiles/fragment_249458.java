public void downheap(int i) {
    int l = 2 * i;
    int r = 2 * i + 1; 
    int small = i;     
    if(l<counter && tab[l].getPriority() < tab[small].getPriority())
         small = l;
    if(r<counter && tab[r].getPriority() < tab[small].getPriority())
         small = r;
    if(small!=i)
    {
        BinNode temp = tab[i];
        tab[i] = tab[small];
        tab[small] = temp;
        downheap(small); //you need to call downheap again on the small to find new pos for i (i became small after swap). 
        //i = 1, when you call downheap after delete. The node at i=1 will move down if it is bigger.
    }
}