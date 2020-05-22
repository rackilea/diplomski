public int do(int a){

    if(a==0){
        return 1 ;
    }else{
        return a * do(a-1);
    }
}