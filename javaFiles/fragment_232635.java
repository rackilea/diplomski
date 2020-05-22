public static int getMiddle(int a, int b, int c, int d, int e){

    int temp;

    if(a>b){
        temp=b; b=a; a=temp;
    }
    if(b>c){
        temp=c; c=b; b=temp;
    }
    if(c>d){
        temp=d; d=c; c=temp;
    }
    if(d>e){
        temp=e; e=d; d=temp;
    }

    if( e>d && d>c && c>b && b>a )
        return c;
    else
        return getMiddle(a, b, c, d, e);
}