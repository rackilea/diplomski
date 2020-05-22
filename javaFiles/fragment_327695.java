public int possibilities (int n){
    int pos1=0;
    int pos3 =0;
    if (n>2){
        pos3 = possibilities(n-3);
    }
    if (n>0) {
        pos1 = possibilities(n-1);
    }
    return pos1 + pos3;
}