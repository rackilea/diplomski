for(int j=0; j<size; j++) {
    if(j>i){
        a1[i][j] = data[j-i];
    }else if(j==i){
        a1[i][j] = data[0];
    }else{
        a1[i][j] = data[i-j];
    }
}