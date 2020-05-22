void pattern(int n){
   int k,i,j ;
   for( k=n; k>0; k--){        
    for(i=n; i>0; i--){
       for(j=k; j>0 ; j--){
           System.out.print(i);
       }       
    }
   System.out.print("$");      
  }
}