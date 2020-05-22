public String hasPassed(){

  String toReturn = null;

  if (totalMark ==100 && totalMark > passMark){
          toReturn="Pass";
  }else if (totalMark != 100){
          toReturn= "There is an error with the mark allocation";
  }
     return toReturn;
}