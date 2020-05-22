public ArrayList<int[]> getVariations(int[] copy){

    int[] cp1 = copy;
    Boolean b = false;
    Boolean d = false;
    Boolean e = false;
    int m = 0;
    ArrayList<int[]> combination = new ArrayList<int[]>();
    for(int i=0; i<N ; i++){
       aloop: for(int j=0; j<N ; j++){
            int[] comb = new int[5];

            for(int k=0; k<N ; k++){
                if(k==i)  {
                    b = true;
                    e = true;
                }
                if(k==i+1){
                    d = true;
                    e = false;
                }
                if(k==j){
                    b = false;
                    e = true;
                    continue;
                }
                if(b && j>=i)
                    comb[k] = cp1[k+1];
                if(!b && j>=i)
                    comb[k] = cp1[k];


                if(e && j<i){
                    comb[k] = cp1[k-1];
                }
                if((j<i || d ) && j<i && !e){
                    comb[k] = cp1[k];
                }
            }
            comb[j] = cp1[i];

            b = false;
            e = false;
            d = false;
            for(int h=0 ; h<N ; h++){
                if(comb[h] == cp1[h]){
                   b = true;
                }
                else{
                    b = false;
                    break;
                }
            }
           if(b){
               b = false;
               continue aloop;
           }

            combination.add(m , comb);
           m++;
            for(int n=0; n<N ; n++){
                int[] ab = combination.get(m-1) ;
                System.out.print(ab[n]);

            }
            System.out.println("");
        }
    }
    System.out.println("");
    return (combination);
}