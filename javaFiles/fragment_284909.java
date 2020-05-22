int deltaGivenByUser = scan.nextInt();

for(int i = 0; i < array.length; i++){
  for(int j = 0; j < array.length; j++){
    if(Math.abs(array[i][j] - average) >= deltaGivenByUser) {
      ...