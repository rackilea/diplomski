int parent(int i)
{
    return i/2;
}

public void upheap(int i) {
    while((i > 1) && (tab[i].getPriority() < tab[parent(i)].getPriority())) {
        BinNode temp = tab[parent(i)]; // it should not be i-1 but parent of i that is i/2
        tab[parent(i)] = tab[i];
        tab[i] = temp;
        i = parent(i);
    }
}