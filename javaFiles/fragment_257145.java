// don't declare k here
for(int i=0;i<array.length;i++){

 for(int k=0;k<array[i].length;k++){
      array[i][k]=rand.nextInt(9901)+100;
      System.out.print(array[i][k]);


 }
 System.out.println(); // separate rows
}