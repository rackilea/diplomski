long pow(long x,int n){
    if(n<=0)return 1;
    if(n==1)return x;
    if(n==2)return (x * x);


    if(n%2==0){
        return pow(pow(x, n/2),2);
    }else{

        return x*pow(x, n-1);
    }




}