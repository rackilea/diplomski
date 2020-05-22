int i=1;
while(true){ //this will run forever so be careful
  if (isPyramid(i) && isPerfectSquare(i)){
    System.out.println("Found one! "+i);
  }
  i++;
}