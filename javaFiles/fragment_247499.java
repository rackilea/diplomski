public int[] solution(int[] A, int K) {
    // write your code in Java SE 8

    int [] B =new int [A.length];

    for(int l=0;K>l;K--){
        int j=0;
        for(int i=0;i<A.length;i++){
            if(i==0){
                B[j]=A[A.length-1];
                j++;
            }
            else{
                B[j]=A[i-1];
                j++;
            }
        }

        //below part
        /*for(int i= 0;i<A.length;i++){
            A[i]=B[i];
        }*/
        A = B.clone();

    }
    return B;
}