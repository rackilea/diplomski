public int [] array_intil(int [] neu,int[]A1,int []A2){
    for (int i=0;i<A1.length;i++){
        neu[i]=A1[i];
    }
    for (int k=A1.length;k<neu.length;k++){
        neu[k]=A2[k-A1.length];
    }

    return neu;

}