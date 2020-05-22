for(int i=0; i< array.length; i++) {
    for(int j=0; j< array[i].length; j++) {
        if(! array[i][j]) return false;
    }
}
return false;