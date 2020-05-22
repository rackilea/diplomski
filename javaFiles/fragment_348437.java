while (a[t]<l){
        t=t+1;
        if ( t==min(b,n))    
            return   -1  ;
        if ( a[t]==l)  {
            return t;
        }
 }