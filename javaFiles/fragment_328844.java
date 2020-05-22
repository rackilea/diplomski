public static boolean hasOne(int n) {
  if(n<0) return hasOne(-n); // check for negatives
  if(n==0) return false; // exit condition

  if (n % 10 == 1) {
    return true;
  } 
  return hasOne(n/10);
}