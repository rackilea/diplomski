public static void main(String[] args) {
       int nr3 = 0;
       int end = 1000; 
       int sum=0;

       while ( nr3 < end){
          nr3 +=3;
          sum+=nr3;
          System.out.println( nr3);
      }
      System.out.println( sum);
   }