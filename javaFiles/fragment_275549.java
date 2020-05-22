while(t<b && l<r){

        for(int i=l; i<= r ; i++){
            System.out.println(A[t][i]);
        }
        t++;

        for(int i=t;i<=b;i++){
            System.out.println(A[i][r]);
        }
        r--;

        for(int i=r ; i>=l ; i--){
            System.out.println(A[b][i]);
        }
        b--;

        for(int i=b;i>=t;i--){
            System.out.println(A[i][l]);
        }
        l++;

}