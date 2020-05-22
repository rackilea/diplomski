int even = 0;
    for (int r=0;r<array.length;r++){
       if (array[r] % 2 ==0){
        even = r; 
        break;  
         }        
        }
     System.out.println("The first even number's index is:"+ even );