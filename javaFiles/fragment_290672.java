int size = 3;
int l = 0;
for(int i = 0; i < size; i++){
    for(int j = 0; j < size; j++){
        int x = i + k % size * size;
        int y = j + k / size * size;
        narray[l] = brd.getSquare(x, y);
        brd.getSquare(x, y).setBox(this);
        l++;
    }
}