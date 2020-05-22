PMF add(PMF pmf){
    PMF C= new PMF(x*2);
    for(int i=0; i<x; i++){
        for(int j=0; j<x; j++){
        C.prob[i+j]=prob[i]*pmf.prob(j);
        return C;
        }
    }
return C;
}