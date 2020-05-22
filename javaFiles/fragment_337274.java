public String formatFraction(int[] fraction){
  String result;
  if(fraction[1] == 1){
    result = String.valueOf(fraction[0]);
  }else{
    result = fraction[0] + "/" + fraction[1];
  }
  return result;
}