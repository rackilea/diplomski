for ( int i=0;i<a.length;i++ ) {                                     
             for( int j=i;j<a.length;j++ ) {
                 val = val + **a[i]**;
                 if( val%m > sum )
                 sum = val%m;                 
             }                
            val = 0;
        }

Change 
val = val + a[i];
to 
val = val + a[J];