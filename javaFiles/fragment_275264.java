int max = randomArray[0];
 for(int i=1; i<randomArray.length; i++) {
      if(randomArray[i] > max){
         max = randomArray[i];
       }
    }
  System.out.println("Max number is "+ max);