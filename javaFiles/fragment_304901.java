A=false;
do {
     B=false;
     do {
          C= false;
          do { 
               if (A & (B | C) ) { printf (" %b %b %b\n",A,B,C);
               C=~C;
             } until C==false;
          B=~B;
        } until B==false;
     A=~A;
   } until A==false;