private void findMax(int i, int level) {
    if (i > last) return;
    if(max<h[i].key)
        max=h[i].key;
    findMax(2*i+1, level+1);//left node
    findMax(2*i+2, level+1);//right node
}

public boolean isEmpty() {
    return (last < 0);
}