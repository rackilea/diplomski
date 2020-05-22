for(int i=0; i<list.length; i++){
  System.out.printf(" %-2d",list[i]); //Format left justified
  if ((i+1)%10==0){
    System.out.println(); // Add a new line after 10
  }
}