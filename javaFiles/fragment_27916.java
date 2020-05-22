for (int i=0; i<newarray.length; i++) {
  int sum = 0;
  for(int j=0; j<x && x*i+j < array.length; j++) {
    sum += array[x*i+j];
  }
  newarray[i] = sum;
}
// print the results
for (int xx : newarray) {
  System.out.println(xx);
}