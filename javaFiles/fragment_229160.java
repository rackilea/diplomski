for(j = i; j > 0; j--) {
    numCompares++; 
    if (tmp >= a[j - 1])
        break; 
    a[j] = a[j - 1];
    numMoves++;
}