for (int i=0 ; i<c1.length ; i++) {
    for (int j=0 ; j<c2.length ; j++) {
        newc[newi]=c1[i];
        newc[newi+1] = '*';
        newc[newi+2] = c2[j];
        newc[newi+3] = '+';
        newi+=4;
    }
}