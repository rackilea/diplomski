public int findmaxprice() {
  double max =0;
  int maxIndex = -1;

  for( int i =0; i < nCars; i++) {
    if(max <= Cars[i].getPrice()) {
      max = Cars[i].getPrice();
      maxIndex = i;
    }   
  }

  return maxIndex;
}