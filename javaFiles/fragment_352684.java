double a = 2.1223 ;
int b = (int) a ;

if(a-b > 0.5) { 
    k = b + 1;
}

else { 
    k = b; //No casting needed
}

System.out.println(k);