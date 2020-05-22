public static double getAverage(int a[], boolean even){
  double total = 0;//These are doubles so dividing later does not require casting to retain a decimal (this can be an int if you only want to return integers)
    double counter = 0;
  for(int i = 0; i<a.length; i++){
    if(a[i] % 2 == 0 && even){//even
      counter++;
      total += a[i];
    }else{//odd
      counter++;
      total += a[i];
    }
  }
  if(total == 0){//Avoid dividing by 0.
    return 0; //You can also throw an exception instead of returning 0.
  }
  return total / counter; //Returns the average for even or odd numbers.
}